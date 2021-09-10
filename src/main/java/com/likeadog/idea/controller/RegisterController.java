package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping(value = "ani")
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping("/new")
    public String aniNew(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "ani/createRegisterForm";
    }

    @PostMapping("/new")
    public String create(@Valid RegisterForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createRegisterForm";
        }

        Register register = new Register();
        register.setAniId(form.getAniId());
        register.setAniName(form.getAniName());
        register.setWeight(form.getWeight());
        register.setKind(form.getKind());
        register.setColor(form.getColor());
        register.setGender(form.getGender());
        register.setGender(form.getGender());
        register.setBirth(form.getBirth());
        register.setNeutralization(form.getNeutralization());

        registerService.regJoin(register);

        return "redirect:/main";
    }


    @GetMapping("/list")
    public void aniList() {

    }

    @GetMapping("/update")
    public void aniUpdate() {

    }
}
