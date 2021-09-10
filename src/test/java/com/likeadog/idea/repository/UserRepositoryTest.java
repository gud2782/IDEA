package com.likeadog.idea.repository;

import com.likeadog.idea.domain.User;
import com.likeadog.idea.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        User user = new User();
        user.setUserId("DHW");
        user.setName("do");
        user.setPw("1234");
        user.setPhone("1231231");
        user.setAddress("asdfsfd");

        //when
        Long saveId = userService.join(user);

        //then
        Assert.assertEquals(user, userRepository.findOne(saveId));
        System.out.println("user == saveId : " + (user == userRepository.findOne(saveId)));
        
    }

}