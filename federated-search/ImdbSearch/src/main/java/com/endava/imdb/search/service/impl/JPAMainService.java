package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.domain.jpa.ActorEntity;
import com.endava.imdb.search.domain.jpa.EpisodeEntity;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.service.ActorService;
import com.endava.imdb.search.service.EpisodeService;
import com.endava.imdb.search.service.GenreService;
import com.endava.imdb.search.service.TvSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by btesila on 5/23/2014.
 */

@Service
public class JPAMainService {

    @Autowired
    private GenreService genreService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private EpisodeService episodeService;

    @Autowired
    private TvSeriesService tvSeriesService;


    //-------------------------------------- GenreEntity -----------------------------/

    public GenreEntity findGenre(int genreID) {
        return genreService.find(genreID);

    }

    public GenreEntity findGenreByName(String genreName) {
        return genreService.find(genreName);

    }
    /**
     *   Define a new genre entity and insert it into the corresponding table
     */
    public void insertGenre(String genreName) {
        GenreEntity genreToBeSaved = new GenreEntity();
        genreToBeSaved.setName(genreName);
        genreService.save(genreToBeSaved);
    }

    /**
     * Search for an existing genre, update its name and save it using the new name
     */
    public void updateGenre(int genreID, String newGenreName) {
        GenreEntity genreToBeUpdated = findGenre(genreID);
        genreToBeUpdated.setName(newGenreName);
        genreService.update(genreToBeUpdated);
    }

    /**
     * Delete an existing genre from the database
     */
    public void deleteGenre(int genreID) {
        GenreEntity genreToBeDeleted = findGenre(genreID);
        genreService.remove(genreToBeDeleted);
    }


    //-------------------------------------- ActorEntity -----------------------------/

    public ActorEntity findActor(int actorID) {
        return actorService.find(actorID);

    }

    public ActorEntity findActorByName(String actorName) {
        return actorService.find(actorName);

    }
    /**
     *   Define a new actor entity and insert it into the corresponding table
     */
    public void insertActor(String actorName) {
        ActorEntity actorToBeSaved = new ActorEntity();
        actorToBeSaved.setName(actorName);
        actorService.save(actorToBeSaved);
    }

    /**
     * Search for an existing actor, update its name and save it using the new name
     */
    public void updateActor(int actorID, String newActorName) {
        ActorEntity actorToBeUpdated = findActor(actorID);
        actorToBeUpdated.setName(newActorName);
        actorService.update(actorToBeUpdated);
    }

    /**
     * Delete an existing actor from the database
     */
    public void deleteActor(int actorID) {
        ActorEntity actorToBeDeleted = findActor(actorID);
        actorService.remove(actorToBeDeleted);
    }


    //-------------------------------------- EpisodeEntity -----------------------------/

    public EpisodeEntity findEpisode(int episodeID) {
        return episodeService.find(episodeID);

    }

    public EpisodeEntity findEpisodeByName(String episodeTitle) {
        return episodeService.find(episodeTitle);

    }
    /**
     *   Define a new episode entity and insert it into the corresponding table
     */
    public void insertEpisode(String episodeTitle) {
        EpisodeEntity episodeToBeSaved = new EpisodeEntity();
        episodeToBeSaved.setTitle(episodeTitle);
        episodeService.save(episodeToBeSaved);
    }

    /**
     * Search for an existing episode, update its name and save it using the new name
     */
    public void updateEpisode(int episodeID, String newEpisodeName) {
        EpisodeEntity episodeToBeUpdated = findEpisode(episodeID);
        episodeToBeUpdated.setTitle(newEpisodeName);
        episodeService.update(episodeToBeUpdated);
    }

    /**
     * Delete an existing episode from the database
     */
    public void deleteEpisode(int episodeID) {
        EpisodeEntity episodeToBeDeleted = findEpisode(episodeID);
        episodeService.remove(episodeToBeDeleted);
    }


    //-------------------------------------- TvSeriesEntity -----------------------------/

    public TvSeriesEntity findTvSeries(int tvSeriesID) {
        return tvSeriesService.find(tvSeriesID);

    }

    public TvSeriesEntity findTvSeriesByName(String tvSeriesName) {
        return tvSeriesService.find(tvSeriesName);

    }
    /**
     *   Define a new tvSeries entity and insert it into the corresponding table
     */
    public void insertTvSeries(String tvSeriesName) {
        TvSeriesEntity tvSeriesToBeSaved = new TvSeriesEntity();
        tvSeriesToBeSaved.setTitle(tvSeriesName);
        tvSeriesService.save(tvSeriesToBeSaved);
    }

    /**
     * Search for an existing tvSeries, update its name and save it using the new name
     */
    public void updateTvSeries(int tvSeriesID, String newTvSeriesName) {
        TvSeriesEntity tvSeriesToBeUpdated = findTvSeries(tvSeriesID);
        tvSeriesToBeUpdated.setTitle(newTvSeriesName);
        tvSeriesService.update(tvSeriesToBeUpdated);
    }

    /**
     * Delete an existing tvSeries from the database
     */
    public void deleteTvSeries(int tvSeriesID) {
        TvSeriesEntity tvSeriesToBeDeleted = findTvSeries(tvSeriesID);
        tvSeriesService.remove(tvSeriesToBeDeleted);
    }
}
