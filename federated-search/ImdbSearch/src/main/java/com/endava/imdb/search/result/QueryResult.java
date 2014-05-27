package com.endava.imdb.search.result;

import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tracktv.QueryResultJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by btesila on 5/26/2014.
 */

@Component
//@Scope("session")
public class QueryResult {

    private List<ShowInfo> callbackServerResult;
    private List<TvSeriesJson> poolingServerResult;
    private List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson> syncServerResult;

    public List<ShowInfo> getCallbackServerResult() {
        return callbackServerResult;
    }

    public void setCallbackServerResult(List<ShowInfo> callbackServerResult) {
        this.callbackServerResult = callbackServerResult;
    }

    public List<TvSeriesJson> getPoolingServerResult() {
        return poolingServerResult;
    }

    public void setPoolingServerResult(List<TvSeriesJson> poolingServerResult) {
        System.out.println("Entering in set pooling result "+poolingServerResult.toString());
        this.poolingServerResult = poolingServerResult;
    }

    public List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson> getSyncServerResult() {
        return syncServerResult;
    }

    public void setSyncServerResult(List<com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson> syncServerResult) {
        this.syncServerResult = syncServerResult;
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
