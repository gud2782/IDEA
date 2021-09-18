package com.likeadog.idea.repository;

import com.likeadog.idea.domain.User;
import com.likeadog.idea.domain.Vinfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class V_infoRepository {

    @PersistenceContext
    EntityManager em;

    public void save(User user) {
        em.persist(user);

    }

    public List<Vinfo> findAll() {
        return em.createQuery("select v from Vinfo v", Vinfo.class)
                    .getResultList();
    }


}
