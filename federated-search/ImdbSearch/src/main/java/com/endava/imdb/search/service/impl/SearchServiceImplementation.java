package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.domain.jpa.QueryEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.service.QueryService;
import com.endava.imdb.search.service.SearchService;
import com.endava.imdb.search.service.TvSeriesService;
import com.endava.imdb.search.worker.CallbackServerSearchTask;
import com.endava.imdb.search.worker.PoolingServerSearchTask;
import com.endava.imdb.search.worker.SearchTask;
import com.endava.imdb.search.worker.SyncServerSearchTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bianca on 5/25/2014.
 */
@Service
public class SearchServiceImplementation implements SearchService {

    @Autowired
    private ThreadPoolTaskExecutor asyncTaskExecutor;

    @Autowired
    private SyncServerSearchTask syncServerSearchTask;

    @Autowired
    private CallbackServerSearchTask callbackServerSearchTask;

    @Autowired
    private PoolingServerSearchTask poolingServerSearchTask;

    @Autowired
    private QueryService queryService;

    @Autowired
    private TvSeriesService tvSeriesService;

    @Autowired
    private QueryResult queryResult;

    @Autowired
    private MergeResultService mergeResultService;

    public static ArrayList<SearchTask> searchTasks = new ArrayList<SearchTask>();

    @Override
    public List<TvSeriesEntity> searchFor(String query) {

        QueryEntity queryEntity = queryService.find(query);
        System.out.println("SEARCH FOR "+queryEntity);

        if (queryEntity == null) {
            return searchForUsingServers(query);

        }

        Calendar currentCalendar = Calendar.getInstance();
        Calendar queryCalendar = Calendar.getInstance();
        queryCalendar.setTime(queryEntity.getDateTime());
        long diffMillis = currentCalendar.getTimeInMillis() - queryCalendar.getTimeInMillis();
        long diffMinutes = diffMillis / (60 * 1000);
        System.out.println("Difference in minutes!"+diffMinutes);

        if(diffMinutes > 15){
            return searchForUsingServers(query);

        }

        System.out.println("RESULT taken from DB!!!");
        return queryEntity.getTvSeries();




    }

        public List<TvSeriesEntity> searchForUsingServers(String query){

            syncServerSearchTask.setQuery(query);
            poolingServerSearchTask.setQuery(query);
            callbackServerSearchTask.setQuery(query);

            searchTasks.add(syncServerSearchTask);
            searchTasks.add(poolingServerSearchTask);
            searchTasks.add(callbackServerSearchTask);

            for (SearchTask searchTask : searchTasks) {
                asyncTaskExecutor.execute(searchTask);
            }
            for (; ; ) {
                int count = asyncTaskExecutor.getActiveCount();
                System.out.println("Active Threads : " + count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 0) {
                    System.out.println("No active threads!");
                    break;
                }
            }
            List<TvSeriesEntity> tvSeriesEntities =  mergeResultService.mergeResult();

            System.out.println("TV SERIES TO BE ADDED TO QUERY ");
            System.out.println(tvSeriesEntities);
            QueryEntity queryEntity = new QueryEntity();
            queryEntity.setName(query);
            queryEntity.setDateTime(new Date());
            queryEntity.setTvSeries(tvSeriesEntities);
            System.out.println("QUERY TO BE SAVED");
            System.out.println(queryEntity.toString());
            queryService.save(queryEntity);
            return  tvSeriesEntities;

        }







}
