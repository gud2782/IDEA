package com.likeadog.idea.repository;


import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public void saveDonation(Qrcode qrcode) {
        em.persist(qrcode);
    }

    /*
    public Qrcode findBnumber(String bNumber) {
//        if (bNumber == null || bNumber == ) {
//            return "";
//        }
         return  em.find(Qrcode.class, bNumber);
    }*/

    public Qrcode findBybNumber(String bNumber){
        return em.createQuery("select q from Qrcode q where  q.bNumber = :bNumber",
                Qrcode.class)
                .setParameter("bNumber", bNumber)
                .getResultList().get(0);
    }


    public List<Qrcode> findAll() {
        Query query = em.createQuery("select q from Qrcode q", Qrcode.class);
        List<Qrcode> listall = query.getResultList();

        return listall;

    }
}




    /*
    public Qrcode find1(Long donationIdx) {

        Query query = em.createQuery("select d, r.aniName from Donation d, Register r where d.register.registerIdx = r.registerIdx");
        Donation listDonation = (Donation) query.getResultList();
        return listDonation;
    }
    */

