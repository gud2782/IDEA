package com.likeadog.idea.service;


import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.repository.RegisterVaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegisterVaccineService {

    private final RegisterVaccineRepository registerVaccineRepository;


    public void saveRV(RegisterVaccine registerVaccine){
        registerVaccineRepository.regRV(registerVaccine);
    }


}
