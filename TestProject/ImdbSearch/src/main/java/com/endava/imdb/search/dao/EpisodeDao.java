package com.endava.imdb.search.dao;

import com.endava.imdb.search.domain.jpa.EpisodeEntity;

/**
 * Created by btesila on 5/23/2014.
 */
public interface EpisodeDao {
    public EpisodeEntity find(int id);

    public EpisodeEntity find(String EpisodeEntityName);

    public void save(EpisodeEntity toBeSaved);

    public void update(EpisodeEntity toBeUpdated);

    public void remove(EpisodeEntity toBeRemoved);
}
