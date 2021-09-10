package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterRepository {

    private final EntityManager em;

    public void regSave(Register register) {

        em.persist(register);
    }
    public Register findOneRegister(Long registerIdx) {

        return em.find(Register.class, registerIdx);
    }


    public List<Register> findAll() {
        Query query = em.createQuery("select r, u.userId from Register r , User u where r.user = u.userIdx");
        List<Register> listRegister = query.getResultList();
        return listRegister;

    }
    public List<Register> findByAniId(String aniId) {
        return em.createQuery("select r from Register r where r.aniId = :aniId",
                        Register.class)
                .setParameter("aniId", aniId)
                .getResultList();
    }
}
