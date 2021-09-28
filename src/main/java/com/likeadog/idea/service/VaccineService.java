package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.VaccineForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.domain.Vaccine;
import com.likeadog.idea.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccineService {

    private final VaccineRepository vaccineRepository;
    private final RegisterService registerService;

    @Transactional
    public Long saveVc(Vaccine vaccine) {
        vaccineRepository.regVc(vaccine);
        return vaccine.getVaccineIdx();

    }

    @Transactional
    public Vaccine saveVaccine(String registerIdx, VaccineForm form) {
        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);

        Register register = findRegister(lngregisterIdx);

        //System.out.println("service GEtDonationIdx"+form.getDonationIdx());
        //System.out.println("service GetType"+form.getType());

        Vaccine vaccine = Vaccine.builder()
                .vaccineIdx(form.getVaccineIdx())
                .vNumber(form.getVNumber())
                .vDate(form.getVDate())
                .nDate(form.getNDate())
                .build();


        //System.out.println("서비스: "+ donation.getKind());

        vaccineRepository.regVc(vaccine);



        return vaccine;

    }

    private Register findRegister(Long registerIdx) {
        return registerService.findOne(registerIdx);
    }
}
