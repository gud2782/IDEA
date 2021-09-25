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
        List<Register> registers = transfusionService.findAnis();
//        TransfusionForm transfusionForm = new TransfusionForm();


        model.addAttribute("transfusionForm", new TransfusionForm());
        model.addAttribute("registers", registers );


        return "transfusion/createTransfusionForm";

    }



    @PostMapping("/new")
    public String create(@RequestParam("registerIdx") String registerIdx, @ModelAttribute("form") TransfusionForm form) {


        System.out.println("getTransfusionIdx:" + form.getTransfusionIdx());
        transfusionService.saveTransfusion(registerIdx, form);
//

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


        TransfusionForm form = transfusionService.getUpdateTransfusion(transfusionIdx);

        model.addAttribute("form", form);
        return "transfusion/updateTransfusionForm";




    }


    @PostMapping("/{transfusionIdx}/update")
    public String updateTrans(@PathVariable String transfusionIdx, @ModelAttribute("form") TransfusionForm form) {

       transfusionService.updateTransfusion(transfusionIdx, form);
        return "redirect:/transfusion/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{transfusionIdx}/detail")
    public String dosDetail(@PathVariable("transfusionIdx") Long transfusionIdx, Model model) {

        Transfusion transfusion = transfusionService.findOne(transfusionIdx);
        model.addAttribute("transfusion", transfusion);

        return "transfusion/detail";

    }


}


