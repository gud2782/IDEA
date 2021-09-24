package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Transfusion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TransfusionRepository {

    @PersistenceContext
    EntityManager em;

    public TransfusionRepository(EntityManager em) {
        this.em = em;
    }

    public void regTrans(Transfusion transfusion) {
        if(transfusion.getTransfusionIdx() == null) {
            em.persist(transfusion); //신규생성 개념
        } else {
            em.merge(transfusion); //업데이트 개념
        }
    }

    public List<Transfusion> findAll() {
        Query query = em.createQuery("select t from Transfusion t", Transfusion.class);
        List<Transfusion> listall = query.getResultList();

        System.out.println("transfusion List");
        return listall;
    }

    public Transfusion findOne(Long transfusionIdx) {
        return em.find(Transfusion.class, transfusionIdx);
    }
}
