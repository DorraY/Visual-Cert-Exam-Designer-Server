package com.DAO;

import com.Model.Theme;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ThemeDAO {

    @PersistenceContext
    private  EntityManager entityManager;

    public  int insert(Theme theme) {
        entityManager.persist(theme);
        return theme.getThCode();
    }
}
