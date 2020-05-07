package com.service;

import com.Model.Chapitre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ChapitreDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Chapitre chapitre) {
        entityManager.persist(chapitre);
        return chapitre.getChCode();
    }
}
