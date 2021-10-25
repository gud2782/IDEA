package com.likeadog.idea.controller;


import com.likeadog.idea.controller.form.QrcodeForm;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.dto.QrcodeDto;
import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import java.util.List;


@Controller
@AllArgsConstructor
public class QrcodeController {

    private final QrcodeService qrcodeService;



    @GetMapping("/bNumber/new/donation")
    public String donationForm(Model model){
        model.addAttribute("qrcodeForm", new QrcodeForm());
        return "home/bloodDonation";
    }




    @PostMapping("/bNumber/new/donation")
    public String donationFormCreate(@RequestParam("bNumber") String bNumber,@RequestParam("dosId") String dosId , QrcodeForm form) {


        qrcodeService.saveDonation(bNumber,dosId, form);

        return "redirect:/blood/list";
    }

    @GetMapping("/bNumber/new/transfusion")
    public String transfusionForm(Model model){
        model.addAttribute("qrcodeForm", new QrcodeForm());
        return "home/bloodTransfusion";
    }




    @PostMapping("/bNumber/new/transfusion")
    public String transfusionFormCreate(@RequestParam("bNumber") String bNumber,@RequestParam("transId") String transId , QrcodeForm form) {


        //  System.out.println("get:" + form.getBNumber() + form.getDonation().getRegister().getAniName());
        qrcodeService.saveTransfusion(bNumber,transId, form);

        return "redirect:/blood/list";
    }



    //혈액번호 생성
    @GetMapping("qr/blood")
    public String genBnumber() {
        qrcodeService.makeBnumbers();
        return "qr/create";

    }

    @GetMapping("blood/list")
    public String bloodList(Model model) {

        List<QrcodeDto> qrcodeDtos = qrcodeService.getqrcodeDtos();

        model.addAttribute("qrcodeDtos", qrcodeDtos);
        return "home/bloodList";

    }






}




