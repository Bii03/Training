package com.endava.imdb.search.domain.jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Bianca on 5/24/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Aka {
    private String content;
    private String attr;
    private String country;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Aka{" +
                "content='" + content + '\'' +
                ", attr='" + attr + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
