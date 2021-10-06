package com.likeadog.idea.repository;

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
    
    @Test //(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        User user1 = new User();
        user1.setUserId("LHN");
        user1.setName("lee");
        user1.setPw("1234");
        user1.setPhone("1231231");
        user1.setAddress("asdfsfd");

        User user2 = new User();
        user2.setUserId("LHN");
        user2.setName("leehannah");
        user2.setPw("1234");
        user2.setPhone("1231231");
        user2.setAddress("asdfsfd");
        //when

        userService.join(user1);
        userService.join(user2);
        //then

        Assert.fail("예외가 발생해야 한다.");
    }

}