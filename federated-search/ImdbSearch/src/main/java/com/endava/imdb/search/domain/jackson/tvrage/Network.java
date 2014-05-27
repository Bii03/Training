package com.endava.imdb.search.domain.jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Bianca on 5/24/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Network {

    private String content;
    private String country;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Network{" +
                "content='" + content + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
