package com.likeadog.idea.repository;


import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.RegisterVaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    //추가
    public RegisterVaccine findRvByVaccine(Long vaccineIdx) {

        return em.createQuery("select rv from RegisterVaccine rv where rv.vaccine.vaccineIdx = :vaccineIdx", RegisterVaccine.class)
                .setParameter("vaccineIdx",vaccineIdx).getResultList().get(0);
    }
}