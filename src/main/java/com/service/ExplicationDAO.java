package com.service;


import com.Model.Explication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ExplicationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Explication explication) {
        entityManager.persist(explication);
        return explication.getExCode();
    }


}
