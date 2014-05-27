package com.endava.imdb.search.dao;


import com.endava.imdb.search.domain.jpa.QueryEntity;

/**
 * Created by btesila on 5/27/2014.
 */
public interface QueryDao {

    public QueryEntity find(int id);

    public QueryEntity find(String queryEntityName);

    public void save(QueryEntity toBeSaved);

    public void update(QueryEntity toBeUpdated);

    public void remove(QueryEntity toBeRemoved);
}
