package com.endava.imdb.search.domain.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by btesila on 5/27/2014.
 */

@Entity
@Table(name = "queries")
public class QueryEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_query")
    private int id;

    @Column(name = "query")
    private String name;

    @Column(name = "datetime")
    private Date dateTime;

    @OneToMany(targetEntity = TvSeriesEntity.class,  fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_query")
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<TvSeriesEntity> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TvSeriesEntity> tvSeries) {
        this.tvSeries = tvSeries;
    }

    @Override
    public String toString() {
        return "QueryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
