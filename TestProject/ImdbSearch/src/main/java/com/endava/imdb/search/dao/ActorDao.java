package com.endava.imdb.search.dao;

import com.endava.imdb.search.domain.jpa.ActorEntity;

/**
 * Created by btesila on 5/23/2014.
 */
public interface ActorDao {
    public ActorEntity find(int id);

    public ActorEntity find(String ActorEntityName);

    public void save(ActorEntity toBeSaved);

    public void update(ActorEntity toBeUpdated);

    public void remove(ActorEntity toBeRemoved);
}
