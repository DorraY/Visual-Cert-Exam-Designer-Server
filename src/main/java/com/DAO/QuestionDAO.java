package com.DAO;
import com.Model.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class QuestionDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public int insert(Question question) {
        entityManager.persist(question);
        return question.getQuCode();
    }

}
