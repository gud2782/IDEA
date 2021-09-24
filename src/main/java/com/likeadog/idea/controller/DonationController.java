package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.service.DonationService;
import com.likeadog.idea.service.RegisterService;
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
    private final RegisterService registerService;


    //기존 등록된 반려견의 헌혈 등록
    @GetMapping("/new")
    public String createForm(Model model){
        List<Register> registers = registerService.findAnis();
        DonationForm donationForm = new DonationForm();


        model.addAttribute("donationForm", new DonationForm());
        model.addAttribute("registers", registers );


        return "donation/createDonationForm";

    }



    @PostMapping("/new")
    public String create(@RequestParam("registerIdx") String registerIdx, DonationForm form) {

        //넘어오는 registerIdx , 기준 파싱
        String[] parsedRegId = registerIdx.split(",");
        System.out.println(registerIdx);
        //파싱한 결과들 중 registerIdx에 해당하는 부분 Long으로 캐스팅
        Long lngregisterIdx = Long.parseLong(parsedRegId[0]);


        Register registers = registerService.findOne(lngregisterIdx);
        Donation donation = new Donation();

        donation.setDonationIdx(form.getDonationIdx());
        donation.setRegister(registers);
        donation.setDWeight(form.getDWeight());
        donation.setKind(registers.getKind());
        donation.setDDate(form.getDDate());
        donation.setDHos(form.getDHos());
        donation.setType(form.getType());
        donation.setDPack(form.getDPack());
        donation.setNeutralization(registers.getNeutralization());
        donation.getRegister().getAniId();
        donation.getRegister().getRegisterIdx();


        System.out.println(donation.getDDate());
        System.out.println(donation.getRegister().getRegisterIdx());
        System.out.println(donation.getRegister().getAniName());



        donationService.saveDo(donation);

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
            Donation donation = donationService.findOne(donationIdx);
            //Register register = registerService.findOne(donation.getRegister().getRegisterIdx());

            DonationForm form = new DonationForm();

            form.setDonationIdx(donation.getDonationIdx());
            form.setDWeight(donation.getDWeight());
            form.setKind(donation.getKind());
            form.setDDate(donation.getDDate());
            form.setDHos(donation.getDHos());
            form.setType(donation.getType());
            form.setDPack(donation.getDPack());
            form.setNeutralization(donation.getNeutralization());
            form.setRegister(donation.getRegister());
            //form.getRegister().getRegisterIdx();

            System.out.println("=========1==========");
            System.out.println(form.getRegister().getRegisterIdx());

            model.addAttribute("form", form);
            return "donation/updateDonationForm";




        }


    @PostMapping("/{donationIdx}/update")
    public String updateDos(@PathVariable String donationIdx, @ModelAttribute("form") DonationForm form) {

        Donation donation = new Donation();

        System.out.println("=========2==========");
        donation.setDonationIdx(form.getDonationIdx());
        donation.setDWeight(form.getDWeight());
        donation.setKind(form.getKind());
        donation.setDDate(form.getDDate());
        donation.setDHos(form.getDHos());
        donation.setType(form.getType());
        donation.setDPack(form.getDPack());
        donation.setNeutralization(form.getNeutralization());
        donation.setRegister(form.getRegister());



        System.out.println("==========3==========");
  


        donationService.saveDo(donation);
        return "redirect:/donation/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{donationIdx}/detail")
    public String dosDetail(@PathVariable("donationIdx") Long donationIdx, Model model) {

        Donation donation = donationService.findOne(donationIdx);
        Register register = registerService.findOne(donation.getRegister().getRegisterIdx());

        
        model.addAttribute("donation", donation);
        model.addAttribute("register", register);
        return "donation/detail";

    }


}