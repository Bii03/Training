package com.endava.imdb.search.domain.jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Bianca on 5/24/2014.
 *
 * This class is used in order to map the callback server first response to an object.
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
