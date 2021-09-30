package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VaccineRepository {

    private final EntityManager em;

    public List<Vaccine> findAll() {
        Query query = em.createQuery("select v from Vaccine v", Vaccine.class);
        List<Vaccine> listall = query.getResultList();

        return listall;
    }

    public void regVc(Vaccine vaccine) {
        if(vaccine.getVaccineIdx() == null) {
            em.persist(vaccine); //신규생성 개념
        } else {
            em.merge(vaccine); //업데이트 개념
        }

    }

    public Vaccine findOne(Long vaccineIdx) {
        return  em.find(Vaccine.class, vaccineIdx);
    }
}
