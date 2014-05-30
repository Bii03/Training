package com.endava.imdb.search.service;

import com.endava.imdb.search.domain.jpa.EpisodeEntity;

/**
 * Created by btesila on 5/23/2014.
 */
public interface EpisodeService {
    public EpisodeEntity find(int id);

    public EpisodeEntity find(String EpisodeEntityName);

    public void save(EpisodeEntity toBeSaved);

    public void update(EpisodeEntity toBeUpdated);

    public void remove(EpisodeEntity toBeRemoved);
}
