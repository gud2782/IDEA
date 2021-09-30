package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/donation")
public class DonationController {

    private final DonationService donationService;



    //기존 등록된 반려견의 헌혈 등록
    @GetMapping("/new")
    public String createForm(Model model){

        List<Register> registers = donationService.findAnis();
        model.addAttribute("donationForm", new DonationForm());
        model.addAttribute("registers", registers );

        return "donation/createDonationForm";
    }


    @PostMapping("/new")
    public String create(@RequestParam("registerIdx") String registerIdx, @ModelAttribute("form") DonationForm form) {

//        System.out.println("getDonationIdx:" + form.getDonationIdx());
        donationService.saveDonation(registerIdx, form);

        return "redirect:/donation/list";
    }



    //등록한 동물정보 리스트조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Donation> dos = donationService.findDos();
        model.addAttribute("dos", dos);
        return "donation/list";
    }



    //등록한 동물정보 수정
    @GetMapping("/{donationIdx}/update")
    public String dosNew(@PathVariable("donationIdx") Long donationIdx, Model model) {

        DonationForm form = donationService.getUpdateDonation(donationIdx);

        model.addAttribute("form", form);
        return "donation/updateDonationForm";

    }



    @PostMapping("/{donationIdx}/update")
    public String updateDos(@PathVariable String donationIdx, @ModelAttribute("form") DonationForm form) {
        donationService.updateDonation(donationIdx, form);
        //donationService.saveDonation(donationIdx,form);

        return "redirect:/donation/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{donationIdx}/detail")
    public String dosDetail(@PathVariable("donationIdx") Long donationIdx, Model model) {

        Donation donation = donationService.findOne(donationIdx);
        model.addAttribute("donation", donation);

        return "donation/detail";

    }



}