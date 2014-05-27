package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.result.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by btesila on 5/26/2014.
 */

@Service
public class MergeResultService {

    @Autowired
    private QueryResult queryResult;

    private List<TvSeriesEntity> syncResult;
    private List<TvSeriesEntity> poolingResult;
    private List<TvSeriesEntity> callbackResult;

    private List<TvSeriesEntity> mergedResult;



    public void mergeSyncPooling(){

        System.out.println("MERGE SYNC WITH POOLING");
        mergedResult = new ArrayList<TvSeriesEntity>();

        if(poolingResult.size() == 0){
            if(syncResult.size() != 0){
                System.out.println("EMPTY POOLING RESULT");
                mergedResult.addAll(syncResult);
            }
            else{
                System.out.println("EMPTY SYNC AND POOLING");
                return;
            }
        }

        if(syncResult.size() == 0){
            if(poolingResult.size() != 0){
                System.out.println("EMPTY SYNC");
                mergedResult.addAll(poolingResult);
            }
            else{
                System.out.println("EMPTY SYNC AND POOLING");
                return;
            }
        }
        for(TvSeriesEntity syncEntity: syncResult){
            for(TvSeriesEntity poolingEntity: poolingResult){
                if(syncEntity.equals(poolingEntity)){
                    mergedResult.add(syncEntity);
                    System.out.println("ADDED FROM BOTH "+syncEntity);
                }
            }
            if(!mergedResult.contains(syncEntity)){
                mergedResult.add(syncEntity);
                System.out.println("ADDED FROM SYNC "+syncEntity);
            }
        }

        for(TvSeriesEntity poolingEntity: poolingResult){
            if(!mergedResult.contains(poolingEntity)){
                System.out.println("ADDED FROM POOLING "+poolingEntity);
                mergedResult.add(poolingEntity);
            }
        }


    }
    public void mergeMergedCallback(){

        System.out.println("MERGE CALLBACK WITH PARTIAL LIST");
        if(mergedResult.size() == 0){
            if(callbackResult.size() != 0){
                System.out.println("EMPTY PARTIAL ");
                mergedResult.addAll(callbackResult);
            }
            else{
                System.out.println("EMPTY PARTIAL AND MERGED");
                return;
            }
        }

        if(callbackResult.size() == 0){
            System.out.println("EMPTY ALL");
           return;
        }

       for(TvSeriesEntity callbackEntity: callbackResult){
           if(!mergedResult.contains(callbackEntity)){
               System.out.println("ADDED FROM CALLBACK "+callbackEntity);
               mergedResult.add(callbackEntity);
           }
       }
    }


    public List<TvSeriesEntity> mergeResult(){
        syncResult = new ArrayList<TvSeriesEntity>();
        poolingResult = new ArrayList<TvSeriesEntity>();
        callbackResult = new ArrayList<TvSeriesEntity>();

        for(TvSeriesJson tvSeriesJson: queryResult.getSyncServerResult()){
            syncResult.add(tvSeriesJson.getJPAEntity());
        }

        for(com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson tvSeriesJson: queryResult.getPoolingServerResult()){
            poolingResult.add(tvSeriesJson.getJPAEntity());
        }

        for(ShowInfo tvSeriesJson: queryResult.getCallbackServerResult()){
            callbackResult.add(tvSeriesJson.getJPAEntity());
        }

        mergeSyncPooling();
        mergeMergedCallback();

        return mergedResult;


    }
}
