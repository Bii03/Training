package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.dao.ActorDao;
import com.endava.imdb.search.domain.jpa.ActorEntity;
import com.endava.imdb.search.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by btesila on 5/23/2014.
 */

@Service
@Transactional(readOnly = true)
public class ActorServiceImplementation implements ActorService {

    @Autowired
    private ActorDao actorDao;

    @Override
    public ActorEntity find(int id) {
        return actorDao.find(id);
    }

    @Override
    public ActorEntity find(String genreName) {
        return actorDao.find(genreName);
    }

    @Override
    @Transactional
    public void save(ActorEntity toBeSaved) {
        actorDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(ActorEntity toBeUpdated) {
        actorDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(ActorEntity toBeRemoved) {
        actorDao.remove(toBeRemoved);
    }
}
