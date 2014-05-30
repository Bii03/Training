package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.domain.translate.TranslateJsonToJPAEntity;
import com.endava.imdb.search.result.QueryResult;
import com.endava.imdb.search.service.MergeResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by btesila on 5/26/2014.
 *
 * This is a service for merging the results from all the three servers  into a list
 * of TvSeriesEntity objects in order to store them into the database for caching purposes.
 */

@Service
public class MergeResultServiceImplementation implements MergeResultService{

    @Autowired
    private QueryResult queryResult;

    List<TvSeriesEntity> syncResult;
    List<TvSeriesEntity> poolingResult;
    List<TvSeriesEntity> callbackResult;
    List<TvSeriesEntity> mergedResult;


    /**
     * This method returns the merged results corresponding to a user's query. The user is identified through
     * the session ID.
     *
     * In order to be stored into the database for caching purposes, the results  are firstly translated to entity
     * objects.
     *
     * @param sessionId
     * @return
     */
    @Override
    public List<TvSeriesEntity> mergeResult(String sessionId){

        syncResult = new ArrayList<TvSeriesEntity>();
        poolingResult = new ArrayList<TvSeriesEntity>();
        callbackResult = new ArrayList<TvSeriesEntity>();
        mergedResult = new ArrayList<TvSeriesEntity>();


        for(TvSeriesJson tvSeriesJson: queryResult.getSyncServerResultPerSession(sessionId)){
            syncResult.add(TranslateJsonToJPAEntity.getJPAEntity(tvSeriesJson));
        }

        for(com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson tvSeriesJson: queryResult.getPoolingServerResultPerSession(sessionId)){
            poolingResult.add(TranslateJsonToJPAEntity.getJPAEntity(tvSeriesJson));
        }

        for(ShowInfo tvSeriesJson: queryResult.getCallbackServerResultPerSession(sessionId)){
            callbackResult.add(TranslateJsonToJPAEntity.getJPAEntity(tvSeriesJson));
        }

        mergeSyncPooling();

        mergeMergedCallback();

        return mergedResult;


    }


    /**
     * This method merges the results from the sync server with the ones from the pooling server.
     */
    @Override
    public void mergeSyncPooling(){

        if(poolingResult.size() == 0){
            if(syncResult.size() != 0){
                mergedResult.addAll(syncResult);
                return;
            }
            else{
                return;
            }
        }
        else if(syncResult.size() == 0){
            mergedResult.addAll(poolingResult);
            return;
        }


        for(TvSeriesEntity syncEntity: syncResult){
            for(TvSeriesEntity poolingEntity: poolingResult){
                if(syncEntity.equals(poolingEntity)){
                    mergedResult.add(syncEntity);
                }
            }
            if(!mergedResult.contains(syncEntity)){
                mergedResult.add(syncEntity);
            }
        }

        for(TvSeriesEntity poolingEntity: poolingResult){
            if(!mergedResult.contains(poolingEntity)){
                mergedResult.add(poolingEntity);
            }
        }


    }

    /**
     * This method merges the results from the callback server with the ones from already partially merged results.
     */
    @Override
    public void mergeMergedCallback(){

        if(mergedResult.size() == 0){
            if(callbackResult.size() != 0){
                mergedResult.addAll(callbackResult);
                return;
            }
            else{
                return;
            }
        }
        else if(callbackResult.size() == 0){
            return;
        }


       for(TvSeriesEntity callbackEntity: callbackResult){
           if(!mergedResult.contains(callbackEntity)){
               mergedResult.add(callbackEntity);
           }
       }
    }



}
