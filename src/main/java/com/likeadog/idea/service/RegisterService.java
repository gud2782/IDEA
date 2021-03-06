package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final UserService userService;

    @Autowired
    QrcodeService qrcodeService;


    public void saveAni(String aniId, RegisterForm form) {

        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        String imgUrl = "";




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
                .hash(form.getHash())
                .build();
        register.setDel(DeleteStatus.NO);
        register.setCreater(userId);
        register.setCDate(LocalDateTime.now());
        System.out.println("ani_img " + form.getAniImg());
        if (form.getAniImg() == null || form.getAniImg().isEmpty()) {
            imgUrl = "/img/card.png";
            register.setAniImg(imgUrl);
        } else {
            imgUrl = "https://ipfs.io/ipfs/"+form.getAniImg();
            register.setAniImg(imgUrl);

        }




        registerRepository.regSave(register);
        Long registerIdx = register.getRegisterIdx();
        qrcodeService.registerQrcode(registerIdx);
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
                .hash(register.getHash())
                .aniImg(register.getAniImg())
                .build();
        form.setDel(register.getDel());
        form.setCDate(register.getCDate());
        form.setCreater(register.getCreater());



        return form;
    }

    public void updateAni(String registerIdx, RegisterForm form) {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);


        Register register = Register.builder()
                .user(userEntity)
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
                .hash(form.getHash())
                .aniImg(form.getAniImg())
                .build();
        register.setDel(form.getDel());
        register.setCreater(form.getCreater());
        register.setCDate(form.getCDate());
        register.setModifier(userEntity.getUserId());
        register.setMDate(LocalDateTime.now());
        registerRepository.regSave(register);



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