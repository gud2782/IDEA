package com.likeadog.idea.controller;

import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.enumCollection.DeleteEnum;
import com.likeadog.idea.repository.DonationRepository;
import com.likeadog.idea.repository.RegisterRepository;
import com.likeadog.idea.service.DonationService;
import com.likeadog.idea.service.RegisterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DonationControllerTest {

    @Autowired
    EntityManager em;
    @Autowired
    DonationService donationService;
    @Autowired
    DonationRepository donationRepository;

    @Autowired
    RegisterService registerService;

    @Autowired
    RegisterRepository registerRepository;


    @Test
    @Rollback(value = false)
    public void 헌혈견등록() {
        //given
        Donation donation = new Donation();
        Register register1 = new Register();

        register1.setAniId("410160020250774");
        register1.setAniName("연이");
        register1.setWeight("3");
        register1.setKind("푸들");
        register1.setCreater("검정");
        register1.setGender("여");
        register1.setBirth("2015.1.20");
        register1.setNeutralization("Y");
        register1.setDel(DeleteEnum.NO);

        registerService.saveAni(register1);

        Register register2 = new Register();

        register2.setAniId("410000000487275");
        register2.setAniName("단이");
        register2.setWeight("2");
        register2.setKind("푸들");
        register2.setCreater("흰색");
        register2.setGender("여");
        register2.setBirth("2019.6.29");
        register2.setNeutralization("Y");
        register2.setDel(DeleteEnum.NO);

        registerService.saveAni(register2);

        em.persist(register1);
        em.persist(register2);

        //when

        Register registers = registerService.findOne(register1.getRegisterIdx());
        Assert.assertEquals(register1, registers);
        System.out.println("register1 == registers : " + (register1 == registers));
        System.out.println(register1.getRegisterIdx());
        System.out.println(registers.getRegisterIdx());

        //then
        donation.setKind(register1.getKind());
        donation.setRegister(register1);
        em.persist(donation);


        System.out.println(donation.getKind());
        System.out.println(donation.getRegister());




    }

}