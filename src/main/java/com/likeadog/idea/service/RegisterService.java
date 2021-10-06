package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.RegisterForm;
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
    public void saveAni(RegisterForm form) {




        Register register = Register.builder()
                .aniId(form.getAniId())
                .aniName(form.getAniName())
                .weight(form.getWeight())
                .kind(form.getKind())
                .color(form.getColor())
                .gender(form.getGender())
                .birth(form.getBirth())
                .neutralization(form.getNeutralization())
                .build();

        registerRepository.regSave(register);
    }

    public RegisterForm getUpdateAni(Long registerIdx) {

        Register register = findOne(registerIdx);

        RegisterForm form = RegisterForm.builder()
                .registerIdx(register.getRegisterIdx())
                .aniId(register.getAniId())
                .aniName(register.getAniName())
                .weight(register.getWeight())
                .kind(register.getKind())
                .color(register.getColor())
                .gender(register.getGender())
                .birth(register.getBirth())
                .neutralization(register.getNeutralization())
                .build();

        return form;
    }


    public  List<Register> findAnis() {
        return registerRepository.findAll();
    }

    public Register findOne(Long registerIdx) {
        System.out.println("222222222222");
        return registerRepository.findOne(registerIdx);
    }


    @Transactional
    public void updateAni(String registerIdx, RegisterForm form) {
        Register register = Register.builder()
                .registerIdx(form.getRegisterIdx())
                .aniId(form.getAniId())
                .aniName(form.getAniName())
                .weight(form.getWeight())
                .kind(form.getKind())
                .color(form.getColor())
                .gender(form.getGender())
                .birth(form.getBirth())
                .neutralization(form.getNeutralization())
                .build();

        registerRepository.regSave(register);

    }
}
