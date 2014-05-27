package com.endava.imdb.search.domain.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * Created by btesila on 5/22/2014.
 */
@Entity
@Table(name = "tv_series")
public class TvSeriesEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_tv_series")
    private int id;

    private String title;
    private int year;
    private String url;
    private String overview;
    private String status;
    private String poster;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "tvrage_id")
    private String tvRageId;
    
    private String country;

    @OneToMany(targetEntity = EpisodeEntity.class, mappedBy="tvSeries", fetch = FetchType.LAZY)
    private List<EpisodeEntity> episodes;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tv_series_has_actors",
            joinColumns=@JoinColumn(name="id_tv_series"),
            inverseJoinColumns=@JoinColumn(name="id_actor"))
    private List<ActorEntity> actors;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tv_series_has_genres",
            joinColumns=@JoinColumn(name="id_tv_series"),
            inverseJoinColumns=@JoinColumn(name="id_genre"))
    private List<GenreEntity> genres;



    @ManyToOne
    @JoinColumn(name = "id_query")
    private QueryEntity query;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImdb_id() {
        return imdbId;
    }

    public void setImdb_id(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTvrage_id() {
        return tvRageId;
    }

    public void setTvrage_id(String tvRageId) {
        this.tvRageId = tvRageId;
    }

    public List<EpisodeEntity> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeEntity> episodes) {
        this.episodes = episodes;
    }

    public List<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTvRageId() {
        return tvRageId;
    }

    public void setTvRageId(String tvRageId) {
        this.tvRageId = tvRageId;
    }

    public QueryEntity getQuery() {
        return query;
    }

    public void setQuery(QueryEntity query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "TvSeriesEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", overview='" + overview + '\'' +
                ", status='" + status + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", tvRageId='" + tvRageId + '\'' +
                ", country='" + country + '\'' +
                ", query=" + query +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TvSeriesEntity that = (TvSeriesEntity) o;

        if ((imdbId != null ? !imdbId.equals(that.imdbId) : that.imdbId != null) && (tvRageId != null ? !tvRageId.equals(that.tvRageId) : that.tvRageId != null) &&  (!title.equals(that.title))) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imdbId != null ? imdbId.hashCode() : 0;
        result = 31 * result + (tvRageId != null ? tvRageId.hashCode() : 0);
        return result;
    }
}
