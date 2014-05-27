package com.endava.imdb.search.form;

import org.springframework.stereotype.Component;

/**
 * Created by Bianca on 5/25/2014.
 */

public class Query {
    public String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Query{" +
                "content='" + content + '\'' +
                '}';
    }
}
