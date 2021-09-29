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


}
