package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.repository.DonationRepository;
import com.likeadog.idea.repository.RegisterRepository;
import com.likeadog.idea.service.DonationService;
import com.likeadog.idea.service.RegisterService;
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


        RegisterForm registerForm1 = RegisterForm.builder()
                .aniId("410160020250774")
                .aniName("연이")
                .weight("3")
                .kind("푸들")
                .color("검정")
                .gender("여")
                .birth("2015.1.20")
                .neutralization("Y")
                .del(DeleteStatus.NO).build();


        registerService.saveAni(registerForm1);

        RegisterForm registerForm2 = RegisterForm.builder()
                .aniId("410000000487275")
                .aniName("단이")
                .weight("2")
                .kind("푸들")
                .color("흰색")
                .gender("여")
                .birth("2019.6.29")
                .neutralization("Y")
                .del(DeleteStatus.NO).build();

        registerService.saveAni(registerForm2);






    }

}