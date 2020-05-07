package com.service;

import com.Model.Examen;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional

public class ExamenDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Examen examen) {
        entityManager.persist(examen);
        return examen.getExId();
    }
}
