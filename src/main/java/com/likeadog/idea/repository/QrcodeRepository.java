package com.likeadog.idea.repository;


import com.likeadog.idea.domain.*;
import com.likeadog.idea.dto.QrcodeDto;
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


    public QrcodeDto getQrcodeDto(Long qrcodeIdx){

        QrcodeDto qrcodeDto = new QrcodeDto();

        Qrcode qrcode= em.createQuery("select q from Qrcode q where  q.qrcodeIdx = :qrcodeIdx",
                Qrcode.class)
                .setParameter("qrcodeIdx", qrcodeIdx)
                .getResultList().get(0);

        qrcodeDto.setBNumber(qrcode.getBNumber());


        try{
            Donation donation = em.createQuery("select d from Donation d where  d.qrcode.qrcodeIdx = :qrcodeIdx",
                    Donation.class)
                    .setParameter("qrcodeIdx", qrcodeIdx)
                    .getResultList().get(0);


            qrcodeDto.setDPack(donation.getDPack());
            qrcodeDto.setDType(donation.getType());
            qrcodeDto.setDaniName(donation.getRegister().getAniName());
            qrcodeDto.setDDate(donation.getDDate());
            qrcodeDto.setDaniId(donation.getRegister().getAniId());
            qrcodeDto.setDHos(donation.getDHos());


        }catch (IndexOutOfBoundsException e){

            qrcodeDto.setDPack("-");
            qrcodeDto.setDType("-");
            qrcodeDto.setDaniName("-");
            qrcodeDto.setDDate("-");
            qrcodeDto.setDaniId("-");
            qrcodeDto.setDHos("-");
        }



        try {
            Transfusion transfusion = em.createQuery("select t from Transfusion t where  t.qrcode.qrcodeIdx = :qrcodeIdx",
                    Transfusion.class)
                    .setParameter("qrcodeIdx", qrcodeIdx)
                    .getResultList().get(0);

            qrcodeDto.setTPack(transfusion.getTPack());
            qrcodeDto.setTType(transfusion.getType());
            qrcodeDto.setTaniName(transfusion.getRegister().getAniName());
            qrcodeDto.setTDate(transfusion.getTDate());
            qrcodeDto.setTaniId(transfusion.getRegister().getAniId());
            qrcodeDto.setTHos(transfusion.getTHos());

        }catch (IndexOutOfBoundsException e){

            qrcodeDto.setTPack("-");
            qrcodeDto.setTType("-");
            qrcodeDto.setTaniName("-");
            qrcodeDto.setTDate("-");
            qrcodeDto.setTaniId("-");
            qrcodeDto.setTHos("-");
        }


        return qrcodeDto;


    }
}



