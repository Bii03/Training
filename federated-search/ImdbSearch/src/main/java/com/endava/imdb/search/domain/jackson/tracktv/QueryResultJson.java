package com.endava.imdb.search.domain.jackson.tracktv;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by btesila on 5/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class QueryResultJson {

    private int noEntries;

    private List<TvSeriesJson> content;

    public int getNoEntries() {
        return noEntries;
    }

    public void setNoEntries(int noEntries) {
        this.noEntries = noEntries;
    }

    public List<TvSeriesJson> getContent() {
        return content;
    }

    public void setContent(List<TvSeriesJson> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "QueryResultJson{" +
                "noEntries=" + noEntries +
                ", content=" + content +
                '}';
    }
}
