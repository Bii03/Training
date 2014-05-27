package com.endava.imdb.search.service;

import com.endava.imdb.search.domain.jpa.TvSeriesEntity;

import java.util.List;

/**
 * Created by Bianca on 5/25/2014.
 */
public interface SearchService {
    public List<TvSeriesEntity> searchFor(String query);
}
