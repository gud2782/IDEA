package com.likeadog.idea.service;

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

    @Transactional
    public Long saveVc(Vaccine vaccine) {
        vaccineRepository.regVc(vaccine);
        return vaccine.getVaccineIdx();

    }
}
