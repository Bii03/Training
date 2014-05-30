package com.endava.imdb.search.result;

import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tracktv.QueryResultJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by btesila on 5/26/2014.
 *
 * This is a bean where all the results corresponding to users' queries are stored. They are stored in three different maps, each
 * one corresponding to a server. Moreover, to differentiate from one user to another, the results are stored in maps having the key
 * corresponding to the user's session ID. Each time a user receives the needed results, they are removed from the maps.
 *
 * A concurrent map is needed since the search processing is dealing with threads and everything has to be thread-safe.
 */

@Component
public class QueryResult {



    private ConcurrentMap<String, List<ShowInfo>> callbackServerResult;
    private ConcurrentMap<String, List<TvSeriesJson>> poolingServerResult;
    private ConcurrentMap<String, List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>> syncServerResult;


    public QueryResult() {
        callbackServerResult = new ConcurrentHashMap<String, List<ShowInfo>>();
        poolingServerResult = new ConcurrentHashMap<String, List<TvSeriesJson>>();
        syncServerResult = new ConcurrentHashMap<String, List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>>();
    }

    public ConcurrentMap<String, List<ShowInfo>> getCallbackServerResult() {
        return callbackServerResult;
    }

    public void setCallbackServerResult(ConcurrentMap<String, List<ShowInfo>> callbackServerResult) {
        this.callbackServerResult = callbackServerResult;
    }

    public ConcurrentMap<String, List<TvSeriesJson>> getPoolingServerResult() {
        return poolingServerResult;
    }

    public void setPoolingServerResult(ConcurrentMap<String, List<TvSeriesJson>> poolingServerResult) {
        this.poolingServerResult = poolingServerResult;
    }

    public ConcurrentMap<String, List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>> getSyncServerResult() {
        return syncServerResult;
    }

    public void setSyncServerResult(ConcurrentMap<String, List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson>> syncServerResult) {
        this.syncServerResult = syncServerResult;
    }

    public List<ShowInfo> getCallbackServerResultPerSession(String sessionId){
        return callbackServerResult.get(sessionId);
    }

    public List<TvSeriesJson> getPoolingServerResultPerSession(String sessionId){
        return poolingServerResult.get(sessionId);
    }

    public List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson> getSyncServerResultPerSession(String sessionId){
        return syncServerResult.get(sessionId);
    }

    public void setCallbackServerResultPerSession(String sessionId, List<ShowInfo> callbackResults){
         callbackServerResult.put(sessionId, callbackResults);
    }

    public void setPoolingServerResultPerSession(String sessionId, List<TvSeriesJson> poolingResults){
        poolingServerResult.put(sessionId, poolingResults);
    }

    public void setSyncServerResultPerSession(String sessionId, List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson> callbackResults){
        syncServerResult.put(sessionId, callbackResults);
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "callbackServerResult=" + callbackServerResult +
                ", poolingServerResult=" + poolingServerResult +
                ", syncServerResult=" + syncServerResult +
                '}';
    }
}
