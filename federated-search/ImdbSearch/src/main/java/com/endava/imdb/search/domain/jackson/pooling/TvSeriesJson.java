package com.endava.imdb.search.domain.jackson.pooling;

import com.endava.imdb.search.domain.jpa.ActorEntity;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class TvSeriesJson {

    @JsonProperty("Title")
    private String Title;

    @JsonProperty("Year")
    private String Year;

    @JsonProperty("Rated")
    private String Rated;

    @JsonProperty("Runtime")
    private String Runtime;

    @JsonProperty("Genre")
    private String Genre;

    @JsonProperty("Director")
    private String Director;

    @JsonProperty("Writer")
    private String Writer;

    @JsonProperty("Actors")
    private String Actors;

    @JsonProperty("Plot")
    private String Plot;

    @JsonProperty("Language")
    private String Language;

    @JsonProperty("Country")
    private String Country;

    @JsonProperty("Awards")
    private String Awards;

    @JsonProperty("Poster")
    private String Poster;

    @JsonProperty("Metascore")
    private String Metascore;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Response")
    private String Response;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    @Override
    public String toString() {
        return "TvSeriesJson{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Rated='" + Rated + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Writer='" + Writer + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Language='" + Language + '\'' +
                ", Country='" + Country + '\'' +
                ", Awards='" + Awards + '\'' +
                ", Poster='" + Poster + '\'' +
                ", Metascore='" + Metascore + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", Response='" + Response + '\'' +
                '}';
    }

    public TvSeriesEntity getJPAEntity(){
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        tvSeriesEntity.setTitle(this.Title);
        tvSeriesEntity.setOverview(this.Plot);
        tvSeriesEntity.setPoster(this.Poster);

        String[] genres = this.Genre.split(", ");
        List<GenreEntity> genreEntities = new ArrayList<GenreEntity>();
        for(String genre: genres){
            GenreEntity genreEntity = new GenreEntity();
            genreEntity.setName(genre);
            genreEntities.add(genreEntity);
        }
        tvSeriesEntity.setGenres(genreEntities);

        String [] actors = this.Actors.split(", ");
        List<ActorEntity> actorEntities = new ArrayList<ActorEntity>();
        for(String actor: actors){
            ActorEntity actorEntity = new ActorEntity();
            actorEntity.setName(actor);
            actorEntities.add(actorEntity);
        }
        tvSeriesEntity.setActors(actorEntities);

        tvSeriesEntity.setCountry(this.Country);

        tvSeriesEntity.setImdb_id(this.imdbID);

        return tvSeriesEntity;
    }
}
