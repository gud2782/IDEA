package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.TransfusionForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.repository.TransfusionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransfusionService {

    @Autowired QrcodeService qrcodeService;

    private final TransfusionRepository transfusionRepository;
    private final RegisterService registerService;
    private final UserService userService;


    @Transactional
    public Transfusion saveTransfusion(String registerIdx, TransfusionForm form) {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        String imgUrl = "";
        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        System.out.println(registerIdx);
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);


        Register register = findRegister(lngregisterIdx);
//        Transfusion transfusion = new Transfusion();

        Transfusion transfusion = Transfusion.builder()
                .transfusionIdx(form.getTransfusionIdx())
                .register(register)
                .tDate(form.getTDate())
                .tHos(form.getTHos())
                .type(form.getType())
                .tPack(form.getTPack())
                .neutralization(form.getNeutralization())
                .kind(form.getKind())
                .tWeight(form.getTWeight())
                .hash(form.getHash())
                .aniImg(form.getAniImg())
                .build();
        transfusion.setDel(DeleteStatus.NO);
        transfusion.setCreater(userEntity.getUserId());
        transfusion.setCDate(LocalDateTime.now());
        if (form.getAniImg() == null || form.getAniImg().isEmpty()) {
            imgUrl = "/img/card.png";
            transfusion.setAniImg(imgUrl);
        } else {
            imgUrl = form.getAniImg();
            transfusion.setAniImg(imgUrl);

        }

        transfusionRepository.regTrans(transfusion);

        Long transfusionIdx = transfusion.getTransfusionIdx();
        System.out.println("transfusionIdx =" +transfusionIdx);

        qrcodeService.transfusionQrcode(transfusionIdx);
        return transfusion;
    }
    public TransfusionForm getUpdateTransfusion(Long transfusionIdx) {
        Transfusion transfusion = findOne(transfusionIdx);

        TransfusionForm form = TransfusionForm.builder()
                .transfusionIdx(transfusion.getTransfusionIdx())
                .tWeight(transfusion.getTWeight())
                .kind(transfusion.getRegister().getKind())
                .tDate(transfusion.getTDate())
                .tHos(transfusion.getTHos())
                .type(transfusion.getType())
                .tPack(transfusion.getTPack())
                .neutralization(transfusion.getRegister().getNeutralization())
                .register(transfusion.getRegister())
                .hash(transfusion.getHash())
                .aniImg(transfusion.getAniImg())
                .build();
        form.setDel(transfusion.getDel());
        form.setCDate(transfusion.getCDate());
        form.setCreater(transfusion.getCreater());


        return form;
    }

    @Transactional
    public void updateTransfusion(String transfusionIdx, TransfusionForm form) {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        Transfusion transfusion = Transfusion.builder()
                .transfusionIdx(form.getTransfusionIdx())
                .tWeight(form.getTWeight())
                .kind(form.getKind())
                .tDate(form.getTDate())
                .tHos(form.getTHos())
                .type(form.getType())
                .tPack(form.getTPack())
                .neutralization(form.getNeutralization())
                .register(form.getRegister())
                .hash(form.getHash())
                .aniImg(form.getAniImg())
                .build();
        transfusion.setDel(form.getDel());
        transfusion.setCDate(form.getCDate());
        transfusion.setCreater(form.getCreater());
        transfusion.setMDate(LocalDateTime.now());
        transfusion.setModifier(userEntity.getUserId());


        transfusionRepository.regTrans(transfusion);
    }

    @Transactional
    public void deleteTrans(Long transfusionIdx) {
        Transfusion transfusion = transfusionRepository.findOne(transfusionIdx);
        transfusion.setDel(DeleteStatus.YES);
        transfusionRepository.regTrans(transfusion);
    }



    private Register findRegister(Long registerIdx) {
        return registerService.findOne(registerIdx);
    }

    public List<Transfusion> findTrans() {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = userService.findByUserID(userId);
        return transfusionRepository.findTransByUserIDX(userEntity.getUserIdx());
        //return transfusionRepository.findAll();
    }

    public Transfusion findOne(Long transfusionIdx) {
        return transfusionRepository.findOne(transfusionIdx);
    }


    public List<Register> findAnis() {
        return  registerService.findAnis();
    }


    public Transfusion findTransfusionByAniId(String transfusionIdx) {
        return transfusionRepository.findTransfusionByAniId(transfusionIdx);
    }

    public void saveTransfusion(Transfusion transfusion) {
        transfusionRepository.regTrans(transfusion);
    }

    public List<Transfusion> findAllTrans() {
        return transfusionRepository.findAll();
    }
}
