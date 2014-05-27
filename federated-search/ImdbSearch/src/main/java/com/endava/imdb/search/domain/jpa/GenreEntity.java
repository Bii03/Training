package com.endava.imdb.search.domain.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */
@Entity
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_query")
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tv_series_has_genres",
            joinColumns=@JoinColumn(name="id_genre"),
            inverseJoinColumns=@JoinColumn(name="id_tv_series"))
    private List<TvSeriesEntity> tvSeries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TvSeriesEntity> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TvSeriesEntity> tvSeries) {
        this.tvSeries = tvSeries;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tvSeries=" + tvSeries +
                '}';
    }
}
