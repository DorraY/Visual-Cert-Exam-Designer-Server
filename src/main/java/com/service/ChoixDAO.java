package com.service;

import com.Model.Choix;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ChoixDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Choix choix) {
        entityManager.persist(choix);
        return choix.getChoixCode();
    }
}
