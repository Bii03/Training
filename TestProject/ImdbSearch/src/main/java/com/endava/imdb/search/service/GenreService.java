package com.endava.imdb.search.service;

import com.endava.imdb.search.domain.jpa.GenreEntity;

/**
 * Created by btesila on 5/23/2014.
 */
public interface GenreService {
    public GenreEntity find(int id);

    public GenreEntity find(String GenreEntityName);

    public void save(GenreEntity toBeSaved);

    public void update(GenreEntity toBeUpdated);

    public void remove(GenreEntity toBeRemoved);
}
