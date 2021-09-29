package com.likeadog.idea.repository;


import com.likeadog.idea.domain.Qrcode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@RequiredArgsConstructor
public class QrcodeRepository  {

    private final EntityManager em;

    public void regQr(Qrcode qrcode) {
        System.out.println("qrcont: "+qrcode.getBNumber());
        if(qrcode.getQrcodeIdx() == null) {
            em.persist(qrcode); //신규생성 개념
        } else {
            em.merge(qrcode); //업데이트 개념
        }
    }

    public void saveQr(Qrcode qrcode){
        em.persist(qrcode);
    }

    /*
    public Qrcode find1(Long donationIdx) {

        Query query = em.createQuery("select d, r.aniName from Donation d, Register r where d.register.registerIdx = r.registerIdx");
        Donation listDonation = (Donation) query.getResultList();
        return listDonation;
    }
    */

}
