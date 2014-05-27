package com.endava.imdb.search.dao.implementation;


import com.endava.imdb.search.dao.EpisodeDao;
import com.endava.imdb.search.domain.jpa.EpisodeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */

@Repository
public class EpisodeDaoImplementation implements EpisodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    private String QUERY_FIND_EPISODE_BY_NAME = "Select e from EpisodeEntity e where e.title = :title";

        public EpisodeEntity find(int id) {
        return entityManager.find(EpisodeEntity.class, id);
    }

    public EpisodeEntity find(String EpisodeEntityName) {

        EpisodeEntity EpisodeEntity = null;

        List<EpisodeEntity> EpisodeEntityList = entityManager.createQuery(QUERY_FIND_EPISODE_BY_NAME)
                .setParameter("title", EpisodeEntityName)
                .getResultList();

        if(EpisodeEntityList.size() > 0){
            EpisodeEntity = EpisodeEntityList.get(0);
        }

        return  EpisodeEntity;

    }

    @Override
    public void save(EpisodeEntity toBeSaved) {

        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    @Override
    public void update(EpisodeEntity toBeUpdated) {

        entityManager.merge(toBeUpdated);
        entityManager.flush();

    }


    @Override
    public void remove(EpisodeEntity toBeRemoved) {

        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
    }
}
