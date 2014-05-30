package com.endava.imdb.search.service;

import com.endava.imdb.search.domain.jpa.TvSeriesEntity;

/**
 * Created by btesila on 5/23/2014.
 */
public interface TvSeriesService {
    public TvSeriesEntity find(int id);

    public TvSeriesEntity find(String TvSeriesEntityName);

    public void save(TvSeriesEntity toBeSaved);

    public void update(TvSeriesEntity toBeUpdated);

    public void remove(TvSeriesEntity toBeRemoved);
}
