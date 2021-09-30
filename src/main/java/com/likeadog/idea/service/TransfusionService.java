package com.likeadog.idea.service;

import com.likeadog.idea.controller.form.TransfusionForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.repository.TransfusionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransfusionService {

    private final TransfusionRepository transfusionRepository;
    private final RegisterService registerService;

    @Transactional
    public Transfusion saveTransfusion(String registerIdx, TransfusionForm form) {

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
                .build();


        transfusionRepository.regTrans(transfusion);
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
                .build();
        return form;
    }

    @Transactional
    public void updateTransfusion(String transfusionIdx, TransfusionForm form) {

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
                .build();

        transfusionRepository.regTrans(transfusion);
    }



    private Register findRegister(Long registerIdx) {
        return registerService.findOne(registerIdx);
    }

    public List<Transfusion> findTrans() {
        return transfusionRepository.findAll();
    }

    public Transfusion findOne(Long transfusionIdx) {
        return transfusionRepository.findOne(transfusionIdx);
    }


    public List<Register> findAnis() {
        return  registerService.findAnis();
    }
}
