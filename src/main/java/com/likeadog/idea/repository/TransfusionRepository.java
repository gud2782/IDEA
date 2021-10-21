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

    public void regTrans(Transfusion transfusion) {
        if(transfusion.getTransfusionIdx() == null) {
            em.persist(transfusion); //신규생성 개념
        } else {
            em.merge(transfusion); //업데이트 개념
        }
    }

    public List<Transfusion> findTransByUserIDX(Long userIdx) {
        return em.createQuery("select t from Transfusion t where t.del='NO' and t.register.user.userIdx = :userIdx", Transfusion.class)
                .setParameter("userIdx", userIdx)
                .getResultList();

    }

    public Transfusion findOne(Long transfusionIdx) {
        return em.find(Transfusion.class, transfusionIdx);
    }


    public Transfusion findTransfusionByAniId(String aniId) {
        System.out.println(aniId);
        return em.createQuery("select t from Transfusion t where  t.register.aniId = :aniId",
                Transfusion.class)
                .setParameter("aniId", aniId)
                .getResultList().get(0);
    }
}
