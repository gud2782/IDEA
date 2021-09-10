package com.likeadog.idea.repository;

import com.likeadog.idea.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository  {

    @PersistenceContext
    EntityManager em;

    public void save(User user) {
        em.persist(user);
    }
    public User findOne(Long user_idx) {
        return em.find(User.class, user_idx);
    }
    public List<User> findAll() {
        return em.createQuery("select m from user m", User.class)
                .getResultList();
    }
    public List<User> findByUserId(String userId) {
        return em.createQuery("select m from user m where m.userId = :userId",
                        User.class)
                .setParameter("userId", userId)
                .getResultList();
    }



}
