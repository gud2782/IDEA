package com.likeadog.idea.service;

import com.likeadog.idea.domain.Vinfo;
import com.likeadog.idea.enumCollection.FirstStatus;
import com.likeadog.idea.enumCollection.SecondStatus;
import com.likeadog.idea.enumCollection.ThirdStatus;
import com.likeadog.idea.repository.VinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VinfoService {

    private final VinfoRepository vinfoRepository;

    public List<Vinfo> findVcs() {

        return vinfoRepository.findAll();

    }

    public Vinfo findVaccine(Long vaccineIdx) {

        return vinfoRepository.findOne(vaccineIdx);

    }

    @Transactional
    public void saveVcs(Vinfo vinfo) {

        vinfoRepository.save(vinfo);

    }

    public Vinfo vInfoMaker(FirstStatus firstStatus, SecondStatus secondStatus, ThirdStatus thirdStatus){
        String first="";
        String second="";
        String third ="";
        switch (firstStatus){
            case DHPPL:first="1";
                break;
            case Coronavirus:first="2";
                break;
            case Kennel_Cough:first="3";
                break;
            case Rabies:first="4";
                break;
        }

        switch (secondStatus){
            case basic:second="1";
                break;
            case additional: second="2";
                break;
            case extra:second="3";
                break;

        }

        switch (thirdStatus){
            case Canine_Distemper:third="1";
                break;
            case Hepatitis:third="2";
                break;
            case Leptospira:third="3";
                break;
            case Parainfluenza:third="4";
                break;
            case Parvovirus:third="5";
                break;
            default:third="0";
                break;
        }

        String strnumber = first+second+third;
        long number = Long.parseLong(strnumber);
        System.out.println(number);
        Vinfo vinfo = new Vinfo();
        vinfo.setVInfoIdx(number);
        vinfo.setFirst(firstStatus);
        vinfo.setSecond(secondStatus);
        vinfo.setThird(thirdStatus);

        return vinfo;
    }

    public Vinfo findVInfo(long vInfoIdx){
        List<Vinfo> vinfos = vinfoRepository.findVInfo(vInfoIdx);
        Vinfo vinfo = vinfos.get(0);
        return vinfo;
    }



}
