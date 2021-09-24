package com.likeadog.idea.service;

import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.enumCollection.FirstEnum;
import com.likeadog.idea.enumCollection.SecondEnum;
import com.likeadog.idea.enumCollection.ThirdEnum;
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
        vinfo1.setFirst(FirstEnum.DHPPL);
        vinfo1.setSecond(SecondEnum.basic);
        vinfo1.setThird(ThirdEnum.Canine_Distemper);
        vinfo2.setFirst(FirstEnum.DHPPL);
        vinfo2.setSecond(SecondEnum.basic);
        vinfo2.setThird(ThirdEnum.Hepatitis);
        vinfo3.setFirst(FirstEnum.DHPPL);
        vinfo3.setSecond(SecondEnum.basic);
        vinfo3.setThird(ThirdEnum.Leptospira);
        vinfo4.setFirst(FirstEnum.DHPPL);
        vinfo4.setSecond(SecondEnum.basic);
        vinfo4.setThird(ThirdEnum.Parainfluenza);
        vinfo5.setFirst(FirstEnum.DHPPL);
        vinfo5.setSecond(SecondEnum.basic);
        vinfo5.setThird(ThirdEnum.Parvovirus);

        //혼합예방접종 - 추가 - 홍역/간염/렙토스피라/파라인플루엔자/파보장염
        vinfo6.setFirst(FirstEnum.DHPPL);
        vinfo6.setSecond(SecondEnum.additional);
        vinfo6.setThird(ThirdEnum.Canine_Distemper);
        vinfo7.setFirst(FirstEnum.DHPPL);
        vinfo7.setSecond(SecondEnum.additional);
        vinfo7.setThird(ThirdEnum.Hepatitis);
        vinfo8.setFirst(FirstEnum.DHPPL);
        vinfo8.setSecond(SecondEnum.additional);
        vinfo8.setThird(ThirdEnum.Leptospira);
        vinfo9.setFirst(FirstEnum.DHPPL);
        vinfo9.setSecond(SecondEnum.additional);
        vinfo9.setThird(ThirdEnum.Parainfluenza);
        vinfo10.setFirst(FirstEnum.DHPPL);
        vinfo10.setSecond(SecondEnum.additional);
        vinfo10.setThird(ThirdEnum.Parvovirus);

        //혼합예방접종 - 보강 - 홍역/간염/렙토스피라/파라인플루엔자/파보장염
        vinfo11.setFirst(FirstEnum.DHPPL);
        vinfo11.setSecond(SecondEnum.extra);
        vinfo11.setThird(ThirdEnum.Canine_Distemper);
        vinfo12.setFirst(FirstEnum.DHPPL);
        vinfo12.setSecond(SecondEnum.extra);
        vinfo12.setThird(ThirdEnum.Hepatitis);
        vinfo13.setFirst(FirstEnum.DHPPL);
        vinfo13.setSecond(SecondEnum.extra);
        vinfo13.setThird(ThirdEnum.Leptospira);
        vinfo14.setFirst(FirstEnum.DHPPL);
        vinfo14.setSecond(SecondEnum.extra);
        vinfo14.setThird(ThirdEnum.Parainfluenza);
        vinfo15.setFirst(FirstEnum.DHPPL);
        vinfo15.setSecond(SecondEnum.extra);
        vinfo15.setThird(ThirdEnum.Parvovirus);

        //코로나바이러스성 장염 - 기초/추가/보강
        vinfo16.setFirst(FirstEnum.Coronavirus);
        vinfo16.setSecond(SecondEnum.basic);
        vinfo17.setFirst(FirstEnum.Coronavirus);
        vinfo17.setSecond(SecondEnum.additional);
        vinfo18.setFirst(FirstEnum.Coronavirus);
        vinfo18.setSecond(SecondEnum.extra);


        //기관, 기관지염 - 기초/추가/보강
        vinfo19.setFirst(FirstEnum.Kennel_Cough);
        vinfo19.setSecond(SecondEnum.basic);
        vinfo20.setFirst(FirstEnum.Kennel_Cough);
        vinfo20.setSecond(SecondEnum.additional);
        vinfo21.setFirst(FirstEnum.Kennel_Cough);
        vinfo21.setSecond(SecondEnum.extra);

        //광견병 - 기초/추가
        vinfo22.setFirst(FirstEnum.Rabies);
        vinfo22.setSecond(SecondEnum.basic);
        vinfo23.setFirst(FirstEnum.Rabies);
        vinfo23.setSecond(SecondEnum.additional);

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