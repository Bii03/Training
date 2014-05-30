package com.endava.imdb.search.service.impl;

import com.endava.imdb.search.dao.QueryDao;
import com.endava.imdb.search.domain.jpa.QueryEntity;
import com.endava.imdb.search.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by btesila on 5/27/2014.
 */

@Service
@Transactional(readOnly = true)
public class QueryServiceImplementation implements QueryService{

    @Autowired
    private QueryDao queryDao;


    @Override
    public QueryEntity find(int id) {
        return queryDao.find(id);
    }

    @Override
    public QueryEntity find(String queryEntityName) {
        return queryDao.find(queryEntityName);
    }

    @Override
    public void save(QueryEntity toBeSaved) {
        queryDao.save(toBeSaved);
    }

    @Override
    public void update(QueryEntity toBeUpdated) {
        queryDao.update(toBeUpdated);
    }

    @Override
    public void remove(QueryEntity toBeRemoved) {
        queryDao.remove(toBeRemoved);
    }
}
