package com.likeadog.idea.service;

import com.likeadog.idea.domain.Register;
import com.likeadog.idea.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    @Transactional
    public void saveAni(Register register) {

        registerRepository.regSave(register);
    }

    public  List<Register> findAnis() {
        return registerRepository.findAll();
    }

    public Register findOne(Long registerIdx) {
            return registerRepository.findOne(registerIdx);
    }

}
