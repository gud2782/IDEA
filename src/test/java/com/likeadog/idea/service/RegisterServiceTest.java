package com.likeadog.idea.service;

import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.User;
import com.likeadog.idea.repository.RegisterRepository;
import com.likeadog.idea.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegisterServiceTest {

    @Autowired RegisterRepository registerRepository;
    @Autowired RegisterService registerService;
    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    @Rollback(value = false)
    public void 동물등록() throws Exception {
        //given
        User user1 = new User();
        user1.setUserId("LHN");
        user1.setName("lee");
        user1.setPw("1234");
        user1.setPhone("1231231");
        user1.setAddress("asdfsfd");

        Long saveId = userService.join(user1);

        Register register = new Register();
        register.setAniId("1111111");
        register.setAniName("연이");
        register.setWeight(3);
        register.setKind("푸들");
        register.setColor("흰색");
        register.setGender('여');
        register.setNeutralization('Y');
        register.setUser(user1);
        register.getUser().getUserId();


        //when

        Long saveAni = registerService.regJoin(register);
        List<Register> all = registerRepository.findAll();

        //then
        Assert.assertEquals(register, registerRepository.findOneRegister(saveAni));
        System.out.println("register == saveAni : " + (register == registerRepository.findOneRegister(saveAni)));
        System.out.println("=============================");
        System.out.println(all);
        System.out.println("=============================");
    }




}