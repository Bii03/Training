package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.dao.GenreDao;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import com.endava.imdb.search.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by btesila on 5/23/2014.
 */
@Service
@Transactional(readOnly = true)
public class GenreServiceImplementation implements GenreService{

    @Autowired
    private GenreDao genreDao;

    @Override
    public GenreEntity find(int id) {
        return genreDao.find(id);
    }

    @Override
    public GenreEntity find(String genreName) {
        return genreDao.find(genreName);
    }

    @Override
    @Transactional
    public void save(GenreEntity toBeSaved) {
        genreDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(GenreEntity toBeUpdated) {
        genreDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(GenreEntity toBeRemoved) {
        genreDao.remove(toBeRemoved);
    }
}
