package com.likeadog.idea.service;


import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.domain.VaccineVinfo;
import com.likeadog.idea.repository.VaccineVInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VaccineVInfoService {

    private final VaccineVInfoRepository vaccineVInfoRepository;


    public void saveVV(VaccineVinfo vaccineVinfo){
        vaccineVInfoRepository.regVV(vaccineVinfo);
    }

    public VaccineVinfo findVV(Long vaccineIdx) {
        return vaccineVInfoRepository.findVV(vaccineIdx);
    }


}
