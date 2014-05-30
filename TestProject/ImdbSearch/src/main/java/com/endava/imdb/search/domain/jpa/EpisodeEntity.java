package com.endava.imdb.search.domain.jpa;

import javax.persistence.*;

/**
 * Created by btesila on 5/22/2014.
 */
@Entity
@Table(name = "episodes")
public class EpisodeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_episode")
    private int id;

    private int season;
    private int number;
    private String title;
    private String url;

    @ManyToOne(targetEntity = TvSeriesEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tv_series")
    private TvSeriesEntity tvSeries;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TvSeriesEntity getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(TvSeriesEntity tvSeries) {
        this.tvSeries = tvSeries;
    }

    @Override
    public String toString() {
        return "EpisodeEntity{" +
                "id=" + id +
                ", season=" + season +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", tvSeries=" + tvSeries +
                '}';
    }
}
