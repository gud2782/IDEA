package com.likeadog.idea.repository;

import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.domain.VaccineVinfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class VaccineVInfoRepository {


    private final EntityManager em;

    public void regVV(VaccineVinfo vaccineVinfo) {
        if(vaccineVinfo.getVaccineVinfoIdx() == null) {
            em.persist(vaccineVinfo); //신규생성 개념
        } else {
            em.merge(vaccineVinfo); //업데이트 개념
        }

    }


    public VaccineVinfo findVV(Long vaccineIdx) {

        return em.find(VaccineVinfo.class, vaccineIdx);
    }



    //추가
    public VaccineVinfo findVvByVaccine(Long vaccineIdx) {

        return em.createQuery("select vv from VaccineVinfo vv where vv.vaccine.vaccineIdx = :vaccineIdx", VaccineVinfo.class)
                .setParameter("vaccineIdx",vaccineIdx).getResultList().get(0);
    }
}