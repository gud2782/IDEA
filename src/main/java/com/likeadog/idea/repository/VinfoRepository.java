package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Vinfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VinfoRepository {

    @PersistenceContext
    EntityManager em;

    public Vinfo findOne(Long vaccineIdx) {
       return em.find(Vinfo.class, vaccineIdx);
    }

    public void save(Vinfo vinfo) {
        em.persist(vinfo);

    }

    public List<Vinfo> findAll() {
        return em.createQuery("select v from Vinfo v ", Vinfo.class)
                    .getResultList();
    }

    public List<Vinfo> findVInfo(long vInfoIdx) {
        return em.createQuery("select v from Vinfo v where v.vInfoIdx= :vInfoIdx", Vinfo.class)
                .setParameter("vInfoIdx",vInfoIdx)
                .getResultList();
    }

    public List<Register> findByAniId(String aniId) {
        return em.createQuery("select r from Register r where r.aniId = :aniId",
                Register.class)
                .setParameter("aniId", aniId)
                .getResultList();
    }


}
