package com.endava.imdb.search.dao.implementation;

import com.endava.imdb.search.dao.GenreDao;
import com.endava.imdb.search.domain.jpa.GenreEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by btesila on 5/23/2014.
 */
@Repository
public class GenreDaoImplementation implements GenreDao {


    @PersistenceContext
    private EntityManager entityManager;

    private String QUERY_FIND_GENRE_BY_NAME = "Select g from GenreEntity g where g.name = :name";

    public GenreEntity find(int id) {
        return entityManager.find(GenreEntity.class, id);
    }

    public GenreEntity find(String GenreEntityName) {

        GenreEntity GenreEntity = null;

        List<GenreEntity> GenreEntityList = entityManager.createQuery(QUERY_FIND_GENRE_BY_NAME)
                .setParameter("name", GenreEntityName)
                .getResultList();

        if(GenreEntityList.size() > 0){
            GenreEntity = GenreEntityList.get(0);
        }

        return  GenreEntity;

    }

    @Override
    public void save(GenreEntity toBeSaved) {

        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    @Override
    public void update(GenreEntity toBeUpdated) {

        entityManager.merge(toBeUpdated);
        entityManager.flush();

    }


    @Override
    public void remove(GenreEntity toBeRemoved) {

        entityManager.remove(entityManager.merge(toBeRemoved));
        entityManager.flush();
    }
}
