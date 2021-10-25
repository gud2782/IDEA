package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Donation;
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

    public Long regTrans(Transfusion transfusion) {
        em.persist(transfusion);

        Long transfusionIdx = transfusion.getTransfusionIdx();
        System.out.println("get transfusionIdx:" + transfusionIdx);
        return transfusionIdx;
    }

    public List<Transfusion> findTransByUserIDX(Long userIdx) {
        return em.createQuery("select t from Transfusion t where t.del='NO' and t.register.user.userIdx = :userIdx", Transfusion.class)
                .setParameter("userIdx", userIdx)
                .getResultList();

    }

    public Transfusion findOne(Long transfusionIdx) {
        return em.find(Transfusion.class, transfusionIdx);
    }


    public Transfusion findTransfusionByAniId(String transfusionIdx) {
        Long transfusionIDx = Long.parseLong(transfusionIdx);
        System.out.println(transfusionIDx);
        return em.createQuery("select t from Transfusion t where  t.transfusionIdx = :transfusionIDx",
                Transfusion.class)
                .setParameter("transfusionIDx", transfusionIDx)
                .getResultList().get(0);
    }

    public List<Transfusion> findAll() {
        Query query = em.createQuery("select t from Transfusion t where t.del='NO'", Transfusion.class);
        List<Transfusion> listall = query.getResultList();
        System.out.println("Repository_listAll : " +listall.get(0).getTransfusionIdx());


        return listall;
    }
}
