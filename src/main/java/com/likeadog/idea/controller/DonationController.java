package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.service.DonationService;
import com.likeadog.idea.service.QrcodeService;
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

    //등록한 헌혈견 삭제
    @PostMapping("/delete")
    public String deleteDo(@RequestParam("donationIdx") Long donationIdx ) {
        donationService.deleteDo(donationIdx);
        return "redirect:/donation/list";
    }

    @RequestMapping("/find")
    public @ResponseBody String findByDosId(String dosId) {
        Donation result = donationService.findDonationByAniId(dosId);


        String resultDosName = result.getRegister().getAniName();
        String resultKind = result.getKind();
        String resultDDate = result.getDDate();
        String resultDHos = result.getDHos();
        String resultDPack = result.getDPack();
        String resultType = result.getType();
        String resultDWeight = result.getDWeight();

        String strResult = resultDosName + "," + resultKind +  "," + resultDDate + "," + resultDHos + "," + resultDPack
                + "," + resultType + "," + resultDWeight;
        System.out.println(strResult);
        return strResult;
    }

    @GetMapping("/admin")
    public String donationList(Model model) {

        List<Donation> AllDos = donationService.findAllDos();
        model.addAttribute("AllDos", AllDos);


        return "admin/donationList";
    }

    //등록한 수혈견 삭제(관리자)
    @PostMapping("/delete/admin")
    public String deleteTrans(@RequestParam("donationIdx") Long donationIdx ) {
        donationService.deleteDo(donationIdx);
        return "redirect:/donation/admin";
    }



}