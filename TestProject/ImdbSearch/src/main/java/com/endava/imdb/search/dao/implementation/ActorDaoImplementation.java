package com.endava.imdb.search.dao.implementation;

import com.endava.imdb.search.dao.ActorDao;
import com.endava.imdb.search.domain.jpa.ActorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */

@Repository
public class ActorDaoImplementation implements ActorDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String QUERY_FIND_ACTOR_BY_NAME = "Select a from ActorEntity a where a.name = :name";

    @Override
    public ActorEntity find(int id) {
        return entityManager.find(ActorEntity.class, id);
    }

    public ActorEntity find(String ActorEntityName) {

        ActorEntity ActorEntity = null;
        List<ActorEntity> ActorEntityList = entityManager.createQuery(QUERY_FIND_ACTOR_BY_NAME)
                .setParameter("name", ActorEntityName)
                .getResultList();
        if(ActorEntityList.size() > 0){
            ActorEntity = ActorEntityList.get(0);
        }

        return  ActorEntity;

    }

    @Override
    public void save(ActorEntity toBeSaved) {

        if(find(toBeSaved.getName()) != null){
            update(toBeSaved);
            return;
        }
        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    @Override
    public void update(ActorEntity toBeUpdated) {

        entityManager.merge(toBeUpdated);
        entityManager.flush();

    }


    @Override
    public void remove(ActorEntity toBeRemoved) {

        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
    }
}
