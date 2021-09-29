package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.VaccineForm;
import com.likeadog.idea.domain.*;
import com.likeadog.idea.enumCollection.FirstStatus;
import com.likeadog.idea.enumCollection.SecondStatus;
import com.likeadog.idea.enumCollection.ThirdStatus;
import com.likeadog.idea.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;
    private final RegisterService registerService;
    private final VinfoService vinfoService;
    private final RegisterVaccineService registerVaccineService;
    private final VaccineVInfoService vaccineVInfoService;


    @Transactional
    public void saveVc(FirstStatus firstStatus, SecondStatus secondStatus
            , ThirdStatus thirdStatus
            , String registerIdx, VaccineForm form) {


        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);

        Register register = findRegister(lngregisterIdx);


        //vinfo select
        // vinfo ==dbvinfo 같은지 검사
        Vinfo vinfo = vinfoService.vInfoMaker(firstStatus,secondStatus,thirdStatus);
        Vinfo dbVinfo = vinfoService.findVInfo(vinfo.getVInfoIdx());


        //vaccine insert
        Vaccine vaccine = Vaccine.builder()
                .nDate(form.getNDate())
                .vDate(form.getVDate())
                .vNumber(form.getVNumber())
                .build();
        vaccineRepository.regVc(vaccine);


        //register vaccine insert

        //register의 PK와 Vaccine의 PK를 RegisterVaccine의 FK로 보내주는 작업
        RegisterVaccine registerVaccine = RegisterVaccine.builder()
                .register(register)
                .vaccine(vaccine)
                .build();

        registerVaccineService.saveRV(registerVaccine);


        //vaccinevinfo insert
        //vaccine의 PK와 vinfo의 PK를 VaccineVinfo의 FK로 보내주는 작업
        VaccineVinfo vaccineVinfo = VaccineVinfo.builder()
                .vaccine(vaccine)
                .vinfo(dbVinfo)
                .build();
    vaccineVInfoService.saveVV(vaccineVinfo);


    }

    private Register findRegister(Long registerIdx) {
        return registerService.findOne(registerIdx);
    }

    public List<Vaccine> findVC() {
        return vaccineRepository.findAll();
    }
}
