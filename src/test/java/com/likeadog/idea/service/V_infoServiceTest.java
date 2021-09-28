package com.likeadog.idea.service;

import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.enumCollection.FirstStatus;
import com.likeadog.idea.enumCollection.SecondStatus;
import com.likeadog.idea.enumCollection.ThirdStatus;
import com.likeadog.idea.repository.VinfoRepository;
import org.junit.jupiter.api.Test;
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
public class V_infoServiceTest {

    @Autowired EntityManager em;
    @Autowired
    VinfoService v_infoService;
    @Autowired
    VinfoRepository v_infoRepository;

    @Test
    @Rollback(value = false)
    public void 백신접종정보() throws Exception {




        //given
        Vinfo vinfo1 = new Vinfo();
        Vinfo vinfo2 = new Vinfo();
        Vinfo vinfo3 = new Vinfo();
        Vinfo vinfo4 = new Vinfo();
        Vinfo vinfo5 = new Vinfo();
        Vinfo vinfo6 = new Vinfo();
        Vinfo vinfo7 = new Vinfo();
        Vinfo vinfo8 = new Vinfo();
        Vinfo vinfo9 = new Vinfo();
        Vinfo vinfo10 = new Vinfo();
        Vinfo vinfo11 = new Vinfo();
        Vinfo vinfo12 = new Vinfo();
        Vinfo vinfo13 = new Vinfo();
        Vinfo vinfo14 = new Vinfo();
        Vinfo vinfo15 = new Vinfo();
        Vinfo vinfo16 = new Vinfo();
        Vinfo vinfo17 = new Vinfo();
        Vinfo vinfo18 = new Vinfo();
        Vinfo vinfo19 = new Vinfo();
        Vinfo vinfo20 = new Vinfo();
        Vinfo vinfo21 = new Vinfo();
        Vinfo vinfo22 = new Vinfo();
        Vinfo vinfo23 = new Vinfo();


        //혼합예방접종 - 기초 - 홍역/간염/렙토스피라/파라인플루엔자/파보장염
        vinfo1.setVInfoIdx(111L);
        vinfo1.setFirst(FirstStatus.DHPPL);
        vinfo1.setSecond(SecondStatus.basic);
        vinfo1.setThird(ThirdStatus.Canine_Distemper);
        vinfo2.setVInfoIdx(112L);
        vinfo2.setFirst(FirstStatus.DHPPL);
        vinfo2.setSecond(SecondStatus.basic);
        vinfo2.setThird(ThirdStatus.Hepatitis);
        vinfo3.setVInfoIdx(113L);
        vinfo3.setFirst(FirstStatus.DHPPL);
        vinfo3.setSecond(SecondStatus.basic);
        vinfo3.setThird(ThirdStatus.Leptospira);
        vinfo4.setVInfoIdx(114L);
        vinfo4.setFirst(FirstStatus.DHPPL);
        vinfo4.setSecond(SecondStatus.basic);
        vinfo4.setThird(ThirdStatus.Parainfluenza);
        vinfo5.setVInfoIdx(115L);
        vinfo5.setFirst(FirstStatus.DHPPL);
        vinfo5.setSecond(SecondStatus.basic);
        vinfo5.setThird(ThirdStatus.Parvovirus);

        //혼합예방접종 - 추가 - 홍역/간염/렙토스피라/파라인플루엔자/파보장염
        vinfo6.setVInfoIdx(121L);
        vinfo6.setFirst(FirstStatus.DHPPL);
        vinfo6.setSecond(SecondStatus.additional);
        vinfo6.setThird(ThirdStatus.Canine_Distemper);
        vinfo7.setVInfoIdx(122L);
        vinfo7.setFirst(FirstStatus.DHPPL);
        vinfo7.setSecond(SecondStatus.additional);
        vinfo7.setThird(ThirdStatus.Hepatitis);
        vinfo8.setVInfoIdx(123L);
        vinfo8.setFirst(FirstStatus.DHPPL);
        vinfo8.setSecond(SecondStatus.additional);
        vinfo8.setThird(ThirdStatus.Leptospira);
        vinfo9.setVInfoIdx(124L);
        vinfo9.setFirst(FirstStatus.DHPPL);
        vinfo9.setSecond(SecondStatus.additional);
        vinfo9.setThird(ThirdStatus.Parainfluenza);
        vinfo10.setVInfoIdx(125L);
        vinfo10.setFirst(FirstStatus.DHPPL);
        vinfo10.setSecond(SecondStatus.additional);
        vinfo10.setThird(ThirdStatus.Parvovirus);

        //혼합예방접종 - 보강 - 홍역/간염/렙토스피라/파라인플루엔자/파보장염
        vinfo11.setVInfoIdx(131L);
        vinfo11.setFirst(FirstStatus.DHPPL);
        vinfo11.setSecond(SecondStatus.extra);
        vinfo11.setThird(ThirdStatus.Canine_Distemper);
        vinfo12.setVInfoIdx(132L);
        vinfo12.setFirst(FirstStatus.DHPPL);
        vinfo12.setSecond(SecondStatus.extra);
        vinfo12.setThird(ThirdStatus.Hepatitis);
        vinfo13.setVInfoIdx(133L);
        vinfo13.setFirst(FirstStatus.DHPPL);
        vinfo13.setSecond(SecondStatus.extra);
        vinfo13.setThird(ThirdStatus.Leptospira);
        vinfo14.setVInfoIdx(134L);
        vinfo14.setFirst(FirstStatus.DHPPL);
        vinfo14.setSecond(SecondStatus.extra);
        vinfo14.setThird(ThirdStatus.Parainfluenza);
        vinfo15.setVInfoIdx(135L);
        vinfo15.setFirst(FirstStatus.DHPPL);
        vinfo15.setSecond(SecondStatus.extra);
        vinfo15.setThird(ThirdStatus.Parvovirus);

        //코로나바이러스성 장염 - 기초/추가/보강
        vinfo16.setVInfoIdx(210L);
        vinfo16.setFirst(FirstStatus.Coronavirus);
        vinfo16.setSecond(SecondStatus.basic);
        vinfo17.setVInfoIdx(220L);
        vinfo17.setFirst(FirstStatus.Coronavirus);
        vinfo17.setSecond(SecondStatus.additional);
        vinfo18.setVInfoIdx(230L);
        vinfo18.setFirst(FirstStatus.Coronavirus);
        vinfo18.setSecond(SecondStatus.extra);


        //기관, 기관지염 - 기초/추가/보강
        vinfo19.setVInfoIdx(310L);
        vinfo19.setFirst(FirstStatus.Kennel_Cough);
        vinfo19.setSecond(SecondStatus.basic);
        vinfo20.setVInfoIdx(320L);
        vinfo20.setFirst(FirstStatus.Kennel_Cough);
        vinfo20.setSecond(SecondStatus.additional);
        vinfo21.setVInfoIdx(330L);
        vinfo21.setFirst(FirstStatus.Kennel_Cough);
        vinfo21.setSecond(SecondStatus.extra);

        //광견병 - 기초/추가
        vinfo22.setVInfoIdx(410L);
        vinfo22.setFirst(FirstStatus.Rabies);
        vinfo22.setSecond(SecondStatus.basic);
        vinfo23.setVInfoIdx(420L);
        vinfo23.setFirst(FirstStatus.Rabies);
        vinfo23.setSecond(SecondStatus.additional);


        v_infoService.saveVcs(vinfo1);
        v_infoService.saveVcs(vinfo2);
        v_infoService.saveVcs(vinfo3);
        v_infoService.saveVcs(vinfo4);
        v_infoService.saveVcs(vinfo5);
        v_infoService.saveVcs(vinfo6);
        v_infoService.saveVcs(vinfo7);
        v_infoService.saveVcs(vinfo8);
        v_infoService.saveVcs(vinfo9);
        v_infoService.saveVcs(vinfo10);
        v_infoService.saveVcs(vinfo11);
        v_infoService.saveVcs(vinfo12);
        v_infoService.saveVcs(vinfo13);
        v_infoService.saveVcs(vinfo14);
        v_infoService.saveVcs(vinfo15);
        v_infoService.saveVcs(vinfo16);
        v_infoService.saveVcs(vinfo17);
        v_infoService.saveVcs(vinfo18);
        v_infoService.saveVcs(vinfo19);
        v_infoService.saveVcs(vinfo20);
        v_infoService.saveVcs(vinfo21);
        v_infoService.saveVcs(vinfo22);
        v_infoService.saveVcs(vinfo23);




    }
}