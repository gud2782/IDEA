package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final UserService userService;
    private final QrcodeService qrcodeService;


    public void saveAni(String aniId, RegisterForm form) {

        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        qrcodeService.registerQrcode(aniId);


        Register register = Register.builder()
                .user(userEntity)
                .aniId(form.getAniId())
                .aniName(form.getAniName())
                .weight(form.getWeight())
                .kind(form.getKind())
                .color(form.getColor())
                .gender(form.getGender())
                .birth(form.getBirth())
                .neutralization(form.getNeutralization())
                .build();
        register.setDel(DeleteStatus.NO);


        registerRepository.regSave(register);
    }

    public RegisterForm getUpdateAni(Long registerIdx) {

        Register register = findOne(registerIdx);

        RegisterForm form = RegisterForm.builder()
                .user(register.getUser())
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
        form.setDel(register.getDel());



        return form;
    }

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
                .user(form.getUser())
                .build();
        register.setDel(form.getDel());

        registerRepository.regSave(register);
        System.out.println("4 : " + form.getDel());
        System.out.println("5 : " + register.getDel());

    }


    public  List<Register> findAnis() {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        return registerRepository.findAniByUserIDX(userEntity.getUserIdx());
    }




    public void deleteAni(Long registerIdx) {
        Register register = registerRepository.findOne(registerIdx);
        register.setDel(DeleteStatus.YES);
        registerRepository.regSave(register);

    }

    public Register findOne(Long registerIdx) {
        return registerRepository.findOne(registerIdx);
    }

    public Register findByAniId(String aniId) {
        return registerRepository.findByAniId(aniId);



    }

    public List<Register> findByPhone(String phone) {
        return registerRepository.findByPhone(phone);
    }
}
