package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.dao.EpisodeDao;
import com.endava.imdb.search.domain.jpa.EpisodeEntity;
import com.endava.imdb.search.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by btesila on 5/23/2014.
 */

@Service
@Transactional(readOnly = true)
public class EpisodeServiceImplementation implements EpisodeService{

    @Autowired
    private EpisodeDao episodeDao;

    @Override
    public EpisodeEntity find(int id) {
        return episodeDao.find(id);
    }

    @Override
    public EpisodeEntity find(String genreName) {
        return episodeDao.find(genreName);
    }

    @Override
    @Transactional
    public void save(EpisodeEntity toBeSaved) {
        episodeDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(EpisodeEntity toBeUpdated) {
        episodeDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(EpisodeEntity toBeRemoved) {
        episodeDao.remove(toBeRemoved);
    }
}
