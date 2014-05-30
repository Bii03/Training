package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.dao.TvSeriesDao;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.service.TvSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by btesila on 5/23/2014.
 */

@Service
@Transactional(readOnly = true)
public class TvSeriesServiceImplementation implements TvSeriesService{

    @Autowired
    private TvSeriesDao tvSeriesDao;

    @Override
    public TvSeriesEntity find(int id) {
        return tvSeriesDao.find(id);
    }

    @Override
    public TvSeriesEntity find(String genreName) {
        return tvSeriesDao.find(genreName);
    }

    @Override
    @Transactional
    public void save(TvSeriesEntity toBeSaved) {
        tvSeriesDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(TvSeriesEntity toBeUpdated) {
        tvSeriesDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(TvSeriesEntity toBeRemoved) {
        tvSeriesDao.remove(toBeRemoved);
    }
}
