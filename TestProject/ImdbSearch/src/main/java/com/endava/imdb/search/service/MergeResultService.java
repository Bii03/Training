package com.endava.imdb.search.service;

import com.endava.imdb.search.domain.jpa.TvSeriesEntity;

import java.util.List;

/**
 * Created by Bianca on 5/30/2014.
 */
public interface MergeResultService {
    List<TvSeriesEntity> mergeResult(String sessionId);
    void mergeSyncPooling();
    void mergeMergedCallback();
}
