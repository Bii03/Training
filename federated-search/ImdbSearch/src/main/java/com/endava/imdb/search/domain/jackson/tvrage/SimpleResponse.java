package com.endava.imdb.search.domain.jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Bianca on 5/24/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class SimpleResponse {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "content='" + content + '\'' +
                '}';
    }
}
