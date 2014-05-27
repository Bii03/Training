package com.endava.imdb.search.dao.implementation;

import com.endava.imdb.search.dao.TvSeriesDao;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import com.endava.imdb.search.domain.jpa.TvSeriesEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */
@Repository
public class TvSeriesDaoImplementation implements TvSeriesDao{
    @PersistenceContext
    private EntityManager entityManager;

    private String QUERY_FIND_TV_SERIES_BY_NAME = "Select t from TvSeriesEntity t where t.title = :title";

    public TvSeriesEntity find(int id) {
        return entityManager.find(TvSeriesEntity.class, id);
    }

    public TvSeriesEntity find(String TvSeriesEntityName) {

        TvSeriesEntity TvSeriesEntity = null;

        List<TvSeriesEntity> TvSeriesEntityList = entityManager.createQuery(QUERY_FIND_TV_SERIES_BY_NAME)
                .setParameter("title", TvSeriesEntityName)
                .getResultList();

        if(TvSeriesEntityList.size() > 0){
            TvSeriesEntity = TvSeriesEntityList.get(0);
        }

        return  TvSeriesEntity;

    }

    @Override
    public void save(TvSeriesEntity toBeSaved) {

        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    @Override
    public void update(TvSeriesEntity toBeUpdated) {

        entityManager.merge(toBeUpdated);
        entityManager.flush();

    }


    @Override
    public void remove(TvSeriesEntity toBeRemoved) {

        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
    }
}
