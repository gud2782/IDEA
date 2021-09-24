package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "ani")
public class RegisterController {

    private final RegisterService registerService;

    //동물정보 등록
    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "ani/createRegisterForm";
    }


    @PostMapping("/new")
    public String create(@Valid RegisterForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "ani/createRegisterForm";
        }

        Register register= new Register();

        register.setAniId(form.getAniId());
        register.setAniName(form.getAniName());
        register.setWeight(form.getWeight());
        register.setKind(form.getKind());
        register.setColor(form.getColor());
        register.setGender(form.getGender());
        register.setGender(form.getGender());
        register.setBirth(form.getBirth());
        register.setNeutralization(form.getNeutralization());

        registerService.saveAni(register);

        return "redirect:/ani/list";
    }

    //등록한 동물정보 리스트조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Register> anis = registerService.findAnis();
        model.addAttribute("anis", anis);
        return "ani/list";
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
