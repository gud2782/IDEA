package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DonationRepository {

    private final EntityManager em;




    public void regDo(Donation donation) {
        if(donation.getDonationIdx() == null) {
            em.persist(donation); //신규생성 개념
        } else {
            em.merge(donation); //업데이트 개념
        }

    }

    public Donation findOne(Long donationIdx) {

        return  em.find(Donation.class, donationIdx);
    }

    public Donation find1(Long donationIdx) {

        Query query = em.createQuery("select d, r.aniName from Donation d, Register r where d.register.registerIdx = r.registerIdx");
        Donation listDonation = (Donation) query.getResultList();
        return listDonation;
    }



    public List<Donation> findAll() {
        Query query = em.createQuery("select d from Donation d", Donation.class);
        List<Donation> listall = query.getResultList();

        System.out.println("listtttttt");
        return listall;


    }







}
