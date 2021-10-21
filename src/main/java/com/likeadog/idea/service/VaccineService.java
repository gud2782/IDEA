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
        // vinfo == dbvinfo 같은지 검사
        Vinfo vinfo = vinfoService.vInfoMaker(firstStatus,secondStatus,thirdStatus);
        Vinfo dbVinfo = vinfoService.findVInfo(vinfo.getVInfoIdx());
        System.out.println(vinfo.getVInfoIdx());


        //vaccine insert
        Vaccine vaccine = Vaccine.builder()
                .nDate(form.getNDate())
                .vDate(form.getVDate())
                .vNumber(form.getVNumber())
                .build();
        vaccineRepository.regVc(vaccine);


        //RegisterVaccine insert
        //register의 PK와 Vaccine의 PK를 RegisterVaccine의 FK로 보내주는 작업
        RegisterVaccine registerVaccine = RegisterVaccine.builder()
                .register(register)
                .vaccine(vaccine)
                .build();

        registerVaccineService.saveRV(registerVaccine);


        //VaccineVinfo insert
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

    @Transactional
    public VaccineForm getUpdateVaccine(Long vaccineIdx) {

        Vaccine vaccine = findOne(vaccineIdx);




        VaccineForm form = VaccineForm.builder()
                .vNumber(vaccine.getVNumber())
                .vaccineVinfos(vaccine.getVaccineVinfos())
                .registerVaccines(vaccine.getRegisterVaccines())
                .nDate(vaccine.getNDate())
                .vaccineIdx(vaccine.getVaccineIdx())
                .vDate(vaccine.getVDate())
                .build();
        return form;
    }


    @Transactional
    public void updateVaccine(String vaccineIdx, VaccineForm form) {
        Vaccine vaccine = Vaccine.builder()
                .vaccineVinfos(form.getVaccineVinfos())
                .vNumber(form.getVNumber())
                .vDate(form.getVDate())
                .nDate(form.getNDate())
                .registerVaccines(form.getRegisterVaccines())
                .vaccineIdx(form.getVaccineIdx())
                .build();
        vaccineRepository.regVc(vaccine);


        RegisterVaccine registerVaccine = RegisterVaccine.builder()
                .vaccine(vaccine)
                .build();
        registerVaccineService.saveRV(registerVaccine);

        VaccineVinfo vaccineVinfo = VaccineVinfo.builder()
                .vaccine(vaccine)
                .build();
        vaccineVInfoService.saveVV(vaccineVinfo);


    }

    private VaccineVinfo findOneVV(Long vaccineIdx) {
        return vaccineVInfoService.findVV(vaccineIdx);
    }

    private RegisterVaccine findOneRV(Long vaccineIdx) {
        return registerVaccineService.findRV(vaccineIdx);
    }

    public Vaccine findOne(Long vaccineIdx) {
        return vaccineRepository.findOne(vaccineIdx);
    }
}
