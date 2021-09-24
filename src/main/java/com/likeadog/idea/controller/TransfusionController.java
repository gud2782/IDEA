package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.TransfusionForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.service.RegisterService;
import com.likeadog.idea.service.TransfusionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "transfusion")
public class TransfusionController {

    private final TransfusionService transfusionService;
    private final RegisterService registerService;


    //기존 등록된 반려견의 수혈 등록
    @GetMapping("/new")
    public String createForm(Model model){
        List<Register> registers = registerService.findAnis();
        TransfusionForm transfusionForm = new TransfusionForm();


        model.addAttribute("transfusionForm", new TransfusionForm());
        model.addAttribute("registers", registers );


        return "transfusion/createTransfusionForm";

    }



    @PostMapping("/new")
    public String create(@RequestParam("registerIdx") String registerIdx, TransfusionForm form) {

        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        System.out.println(registerIdx);
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);


        Register registers = registerService.findOne(lngregisterIdx);
        Transfusion transfusion = new Transfusion();

        transfusion.setTransfusionIdx(form.getTransfusionIdx());
        transfusion.setRegister(registers);
        transfusion.setTWeight(form.getTWeight());
        transfusion.setKind(registers.getKind());
        transfusion.setTDate(form.getTDate());
        transfusion.setTHos(form.getTHos());
        transfusion.setType(form.getType());
        transfusion.setTPack(form.getTPack());
        transfusion.setNeutralization(registers.getNeutralization());
        transfusion.getRegister().getAniId();
        transfusion.getRegister().getRegisterIdx();


        System.out.println(transfusion.getTDate());
        System.out.println(transfusion.getRegister().getRegisterIdx());
        System.out.println(transfusion.getRegister().getAniName());



        transfusionService.saveTrans(transfusion);

        return "redirect:/transfusion/list";
    }

    //등록한 동물정보 리스트조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Transfusion> trans = transfusionService.findTrans();
        model.addAttribute("trans", trans);
        return "transfusion/list";
    }



    //등록한 동물정보 수정
    @GetMapping("/{transfusionIdx}/update")
    public String transNew(@PathVariable("transfusionIdx") Long transfusionIdx, Model model) {
        Transfusion transfusion = transfusionService.findOne(transfusionIdx);
        //Register register = registerService.findOne(donation.getRegister().getRegisterIdx());

        TransfusionForm form = new TransfusionForm();

        form.setTransfusionIdx(transfusion.getTransfusionIdx());
        form.setTWeight(transfusion.getTWeight());
        form.setKind(transfusion.getKind());
        form.setTDate(transfusion.getTDate());
        form.setTHos(transfusion.getTHos());
        form.setType(transfusion.getType());
        form.setTPack(transfusion.getTPack());
        form.setNeutralization(transfusion.getNeutralization());
        form.setRegister(transfusion.getRegister());
        //form.getRegister().getRegisterIdx();

        System.out.println("=========1==========");
        System.out.println(form.getRegister().getRegisterIdx());

        model.addAttribute("form", form);
        return "transfusion/updateTransfusionForm";




    }


    @PostMapping("/{transfusionIdx}/update")
    public String updateTrans(@PathVariable String transfusionIdx, @ModelAttribute("form") TransfusionForm form) {

        Transfusion transfusion = new Transfusion();

        System.out.println("=========2==========");
        transfusion.setTransfusionIdx(form.getTransfusionIdx());
        transfusion.setTWeight(form.getTWeight());
        transfusion.setKind(form.getKind());
        transfusion.setTDate(form.getTDate());
        transfusion.setTHos(form.getTHos());
        transfusion.setType(form.getType());
        transfusion.setTPack(form.getTPack());
        transfusion.setNeutralization(form.getNeutralization());
        transfusion.setRegister(form.getRegister());



        System.out.println("==========3==========");



        transfusionService.saveTrans(transfusion);
        return "redirect:/transfusion/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{transfusionIdx}/detail")
    public String dosDetail(@PathVariable("transfusionIdx") Long transfusionIdx, Model model) {

        Transfusion transfusion = transfusionService.findOne(transfusionIdx);
        Register register = registerService.findOne(transfusion.getRegister().getRegisterIdx());


        model.addAttribute("transfusion", transfusion);
        model.addAttribute("register", register);
        return "transfusion/detail";

    }


}


