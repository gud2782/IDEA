package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Vaccine;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VaccineRepository {

    @PersistenceContext
    EntityManager em;

    public void regVc(Vaccine vaccine) {
        if(vaccine.getVaccineIdx() == null) {
            em.persist(vaccine); //신규생성 개념
        } else {
            em.merge(vaccine); //업데이트 개념
        }

    }
}
