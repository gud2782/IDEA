package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.controller.form.RegisterForm;
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
    public String create(@RequestParam("registerIdx") Long registerIdx, DonationForm form) {

        Register registers = registerService.findOne(registerIdx);
        Donation donation = new Donation();

        donation.setRegister(registers);
        donation.setDWeight(form.getDWeight());
        donation.setKind(registers.getKind());
        donation.setDDate(form.getDDate());
        donation.setDHos(form.getDHos());
        donation.setType(form.getType());
        donation.setDPack(form.getDPack());
        donation.setNeutralization(registers.getNeutralization());
        donation.getRegister().getAniId();

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
    @GetMapping("/{registerIdx}/update")
    public String aniNew(@PathVariable("registerIdx") Long registerIdx, Model model) {
        Register register = registerService.findOne(registerIdx);
        RegisterForm form = new RegisterForm();

        form.setRegisterIdx(register.getRegisterIdx());
        form.setAniId(register.getAniId());
        form.setAniName(register.getAniName());
        form.setWeight(register.getWeight());
        form.setKind(register.getKind());
        form.setColor(register.getColor());
        form.setGender(register.getGender());
        form.setBirth(register.getBirth());
        form.setNeutralization(register.getNeutralization());

        model.addAttribute("form", form);
        return "ani/updateRegisterForm";


//        model.addAttribute("registerForm", new RegisterForm());
//        return "ani/createRegisterForm";
    }


    @PostMapping("/{registerIdx}/update")
    public String updateAni(@PathVariable String registerIdx, @ModelAttribute("form") RegisterForm form) {

        Register register = new Register();


        register.setRegisterIdx(form.getRegisterIdx());
        register.setAniId(form.getAniId());
        register.setAniName(form.getAniName());
        register.setWeight(form.getWeight());
        register.setKind(form.getKind());
        register.setColor(form.getColor());
        register.setGender(form.getGender());
        register.setBirth(form.getBirth());
        register.setNeutralization(form.getNeutralization());

        registerService.saveAni(register);
        return "redirect:/ani/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{registerIdx}/detail")
    public String aniDetail(@PathVariable("registerIdx") Long registerIdx, Model model) {

        Register register = registerService.findOne(registerIdx);

        model.addAttribute("register", register);
        return "ani/detail";

    }


}
