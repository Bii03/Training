package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.domain.jpa.EpisodeEntity;
import com.endava.imdb.search.domain.jpa.QueryEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.service.*;
import com.endava.imdb.search.util.DateTimeDifference;
import com.endava.imdb.search.worker.SearchTask;
import com.endava.imdb.search.worker.impl.CallbackServerSearchTask;
import com.endava.imdb.search.worker.impl.PoolingServerSearchTask;
import com.endava.imdb.search.worker.impl.SyncServerSearchTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Bianca on 5/25/2014.
 */
@Service
public class SearchServiceImplementation implements SearchService {

    private static final int MAXIMUM_DB_STORAGE_PERIOD = 15;

    @Autowired
    private ThreadPoolTaskExecutor asyncTaskExecutor;


    @Autowired
    private SyncServerSearchTask syncServerSearchTask;

    @Autowired
    private CallbackServerSearchTask callbackServerSearchTask;

    @Autowired
    private PoolingServerSearchTask poolingServerSearchTask;

    @Autowired
    private JPAMainService jpaMainService;

    @Autowired
    private MergeResultService mergeResultService;



    public  ArrayList<SearchTask> searchTasks;

    public SearchServiceImplementation() {
        searchTasks = new ArrayList<SearchTask>();
    }



    /**
     * This is used by the controller in order to send the user's query to be processed.
     * There are three cases:
     * - this query has never been sent before by another user. In this case, it is forwarded to the three servers in order
     * to get the result. Afterwards, the merged result is saved into the database for caching purposes and, then, displayed to the user.
     * <p/>
     * - this query has been sent before by other users and the merged result is available in the database, having a timestamp that doesn't exceed
     * 15 minutes in the past. In this case, the result is taken directly from the database\
     * <p/>
     * - this query has been sent before by other users and the merged result is available in the database, but the timestamp exceeds 15 minutes
     * in the past. Thus, the query is forwarded to the servers in order to get an updated version of the result. Moreover, the record in the database corresponding to the query
     * is removed and, afterwards, added with the recently merged result.
     *
     * @param query     - String that contains the user's search keywords
     * @param sessionId - the session ID of the corresponding user
     * @return
     */
    @Override
    public List<TvSeriesEntity> searchFor(String query, String sessionId) {

        QueryEntity queryEntity = jpaMainService.findQueryEntityByName(query);

        if (queryEntity != null) {

            long dateTimeDifferenceInMinutes = DateTimeDifference.getTimeDifferenceInMinutes(new Date(), queryEntity.getDateTime());

            if (dateTimeDifferenceInMinutes < MAXIMUM_DB_STORAGE_PERIOD){
                return queryEntity.getTvSeries();
            }

            jpaMainService.deleteQuery(queryEntity);

        }

        return searchForUsingServers(query, sessionId);

    }

    /**
     * This is used for forwarding the user's query to the three servers in order to get the search results. Afterwards, the results are merged
     * and sent back to the controller.
     * For each server a thread, taken from the thread pool, is allocated. At the end, when the thread pool executor assures that there are no active threads,
     * the results are sent to be merged, saved into the database together with the query, and then sent to the controller to be displayed.
     * @param query
     * @param sessionId
     * @return
     */
    @Override
    public List<TvSeriesEntity> searchForUsingServers(String query, String sessionId) {

        syncServerSearchTask.setQuery(query);
        syncServerSearchTask.setSessionId(sessionId);

        poolingServerSearchTask.setQuery(query);
        poolingServerSearchTask.setSessionId(sessionId);

        callbackServerSearchTask.setQuery(query);


        searchTasks.add(syncServerSearchTask);
        searchTasks.add(poolingServerSearchTask);
        searchTasks.add(callbackServerSearchTask);

        for (SearchTask searchTask : searchTasks) {
            asyncTaskExecutor.execute(searchTask);
        }


        for (; ; ) {

            int count = asyncTaskExecutor.getActiveCount();

            try {
                Thread.sleep(1500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 0) {
                break;
            }
        }

        List<TvSeriesEntity> tvSeriesEntities = mergeResultService.mergeResult(sessionId);

        jpaMainService.insertQuery(query, new Date(), tvSeriesEntities);

        for(TvSeriesEntity tvSeriesEntity: tvSeriesEntities){
            for(EpisodeEntity episodeEntity: tvSeriesEntity.getEpisodes()){
                episodeEntity.setTvSeries(jpaMainService.findTvSeriesByName(tvSeriesEntity.getTitle()));
                jpaMainService.updateEpisode(episodeEntity);
            }
        }


        return tvSeriesEntities;

    }


}
