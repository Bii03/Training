package com.endava.imdb.search.domain.jackson.tracktv;

import com.endava.imdb.search.domain.jpa.ActorEntity;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by btesila on 5/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class TvSeriesJson {

    private String title;
    private int year;
    private String url;
    private String overview;
    private String status;
    private String poster;
    private String air_day;
    private String air_time;
    private String imdb_id;
    private String tvrage_id;
    private String country;

    private List<String> genres;

    private PeopleJson people;

    private List<EpisodeJson> top_episodes;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getAir_day() {
        return air_day;
    }

    public void setAir_day(String air_day) {
        this.air_day = air_day;
    }

    public String getAir_time() {
        return air_time;
    }

    public void setAir_time(String air_time) {
        this.air_time = air_time;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTvrage_id() {
        return tvrage_id;
    }

    public void setTvrage_id(String tvrage_id) {
        this.tvrage_id = tvrage_id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public PeopleJson getPeople() {
        return people;
    }

    public void setPeople(PeopleJson people) {
        this.people = people;
    }

    public List<EpisodeJson> getTop_episodes() {
        return top_episodes;
    }

    public void setTop_episodes(List<EpisodeJson> top_episodes) {
        this.top_episodes = top_episodes;
    }

    @Override
    public String toString() {
        return "TvSeriesJson{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", overview='" + overview + '\'' +
                ", status='" + status + '\'' +
                ", poster='" + poster + '\'' +
                ", air_day='" + air_day + '\'' +
                ", air_time='" + air_time + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", tvrage_id='" + tvrage_id + '\'' +
                ", genres=" + genres +
                ", people=" + people +
                '}';
    }




}
