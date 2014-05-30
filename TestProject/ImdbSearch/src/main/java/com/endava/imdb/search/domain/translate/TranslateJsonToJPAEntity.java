package com.endava.imdb.search.domain.translate;

import com.endava.imdb.search.domain.jackson.pooling.TvSeriesJson;
import com.endava.imdb.search.domain.jackson.tracktv.ActorJson;
import com.endava.imdb.search.domain.jackson.tracktv.EpisodeJson;
import com.endava.imdb.search.domain.jackson.tvrage.ShowInfo;
import com.endava.imdb.search.domain.jpa.ActorEntity;
import com.endava.imdb.search.domain.jpa.EpisodeEntity;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by btesila on 5/28/2014.
 *
 * This is a utility class needed to translate the servers' responses, mapped from Json to Java objects, to
 * entities that are stored in the database for caching purposes.
 */
public class TranslateJsonToJPAEntity {


    public static TvSeriesEntity getJPAEntity(TvSeriesJson tvSeriesJson){
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        tvSeriesEntity.setTitle(tvSeriesJson.getTitle());
        tvSeriesEntity.setOverview(tvSeriesJson.getPlot());
        tvSeriesEntity.setPoster(tvSeriesJson.getPoster());

        String[] genres = tvSeriesJson.getGenre().split(", ");
        List<GenreEntity> genreEntities = new ArrayList<GenreEntity>();
        for(String genre: genres){
            genreEntities.add(getJPAEntityFromGenreString(genre));
        }
        tvSeriesEntity.setGenres(genreEntities);

        String [] actors = tvSeriesJson.getActors().split(", ");
        List<ActorEntity> actorEntities = new ArrayList<ActorEntity>();
        for(String actor: actors){
            actorEntities.add(getJPAEntityFromActorString(actor));
        }
        tvSeriesEntity.setActors(actorEntities);

        tvSeriesEntity.setCountry(tvSeriesJson.getCountry());

        tvSeriesEntity.setImdb_id(tvSeriesJson.getImdbID());

        return tvSeriesEntity;
    }

    public static TvSeriesEntity getJPAEntity(com.endava.imdb.search.domain.jackson.tracktv.TvSeriesJson tvSeriesJson){
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        tvSeriesEntity.setTitle(tvSeriesJson.getTitle());
        tvSeriesEntity.setOverview(tvSeriesJson.getOverview());
        tvSeriesEntity.setPoster(tvSeriesJson.getPoster());
        tvSeriesEntity.setUrl(tvSeriesJson.getUrl());
        tvSeriesEntity.setYear(tvSeriesJson.getYear());
        tvSeriesEntity.setCountry(tvSeriesJson.getCountry());
        tvSeriesEntity.setStatus(tvSeriesJson.getStatus());

        List<EpisodeEntity> episodes = new ArrayList<EpisodeEntity>();
        for(EpisodeJson episodeJson: tvSeriesJson.getTop_episodes()){
            episodes.add(getJPAEntity(episodeJson));
        }
        tvSeriesEntity.setEpisodes(episodes);

        List<ActorEntity> actorEntities = new ArrayList<ActorEntity>();
        for(ActorJson actor: tvSeriesJson.getPeople().getActors()){
            actorEntities.add(getJPAEntity(actor));
        }
        tvSeriesEntity.setActors(actorEntities);

        List<GenreEntity> genreEntities = new ArrayList<GenreEntity>();
        for(String genre: tvSeriesJson.getGenres()){
            genreEntities.add(getJPAEntityFromGenreString(genre));
        }
        tvSeriesEntity.setGenres(genreEntities);
        tvSeriesEntity.setImdb_id(tvSeriesJson.getImdb_id());
        tvSeriesEntity.setTvrage_id(tvSeriesJson.getTvrage_id());
        return tvSeriesEntity;
    }

    public static TvSeriesEntity getJPAEntity(ShowInfo tvSeriesJson){
        TvSeriesEntity tvSeriesEntity = new TvSeriesEntity();
        tvSeriesEntity.setTitle(tvSeriesJson.getShowname());
        tvSeriesEntity.setTvrage_id(tvSeriesJson.getShowid());
        tvSeriesEntity.setUrl(tvSeriesJson.getShowlink());
        tvSeriesEntity.setStatus(tvSeriesJson.getStatus());
        tvSeriesEntity.setCountry(tvSeriesJson.getOrigin_country());
        return tvSeriesEntity;
    }

    public static ActorEntity getJPAEntity(ActorJson actorJson){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName(actorJson.getName());
        return  actorEntity;
    }

    public  static EpisodeEntity getJPAEntity(EpisodeJson episodeJson){
        EpisodeEntity episodeEntity = new EpisodeEntity();
        episodeEntity.setNumber(episodeJson.getNumber());
        episodeEntity.setSeason(episodeJson.getSeason());
        episodeEntity.setTitle(episodeJson.getTitle());
        episodeEntity.setUrl(episodeJson.getUrl());
        return episodeEntity;
    }

    public static GenreEntity getJPAEntityFromGenreString(String genre){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setName(genre);
        return genreEntity;
    }

    public static ActorEntity getJPAEntityFromActorString(String actor){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName(actor);
        return actorEntity;
    }
}
