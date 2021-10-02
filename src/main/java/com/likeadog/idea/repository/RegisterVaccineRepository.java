package com.likeadog.idea.repository;


import com.likeadog.idea.domain.RegisterVaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RegisterVaccineRepository {

    private final EntityManager em;




    public void regRV(RegisterVaccine registerVaccine) {
        if(registerVaccine.getRegisterVaccineIdx() == null) {
            em.persist(registerVaccine); //신규생성 개념
        } else {
            em.merge(registerVaccine); //업데이트 개념
        }

    }


    public RegisterVaccine findRv(Long vaccineIdx) {
        return em.find(RegisterVaccine.class, vaccineIdx);
    }
}
