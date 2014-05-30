package com.endava.imdb.search.domain.jackson.tracktv;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by btesila on 5/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class EpisodeJson {

    private int plays;
    private int season;
    private int number;
    private String title;
    private String url;

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EpisodeJson{" +
                "plays=" + plays +
                ", season=" + season +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
