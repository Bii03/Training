package com.endava.imdb.search.dao.implementation;

import com.endava.imdb.search.dao.QueryDao;
import com.endava.imdb.search.domain.jpa.QueryEntity;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by btesila on 5/27/2014.
 */

@Repository
public class QueryDaoImplementation implements QueryDao{

    @PersistenceContext
    private EntityManager entityManager;

    private static final String QUERY_FIND_QUERY_BY_NAME = "Select q from QueryEntity q where q.name = :name";


    @Override
    public QueryEntity find(int id) {
        return entityManager.find(QueryEntity.class, id);
    }

    @Override
    public QueryEntity find(String queryEntityName) {
        QueryEntity queryEntity = null;

        List<QueryEntity> queryEntityList = entityManager.createQuery(QUERY_FIND_QUERY_BY_NAME)
                .setParameter("name", queryEntityName)
                .getResultList();

        if(queryEntityList.size() > 0){
            queryEntity = queryEntityList.get(0);
        }

        return  queryEntity;
    }

    @Override
    public void save(QueryEntity toBeSaved) {
        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    @Override
    public void update(QueryEntity toBeUpdated) {
        entityManager.merge(toBeUpdated);
        entityManager.flush();
    }

    @Override
    public void remove(QueryEntity toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
    }
}
