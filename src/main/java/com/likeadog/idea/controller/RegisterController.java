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
    public String create(@RequestParam("aniId") String aniId,
                         @Valid RegisterForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "ani/createRegisterForm";
        }
        System.out.println("get:" + form.getAniId() + form.getBirth());
        registerService.saveAni(aniId, form);

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



        RegisterForm form = registerService.getUpdateAni(registerIdx);
        model.addAttribute("form", form);
        return "ani/updateRegisterForm";

    }


    @PostMapping("/{registerIdx}/update")
    public String updateAni(@PathVariable String registerIdx, @ModelAttribute("form") RegisterForm form) {
        registerService.updateAni(registerIdx, form);
        return "redirect:/ani/list";
    }

    //등록한 동물정보 개별조회
    @GetMapping("/{registerIdx}/detail")
    public String aniDetail(@PathVariable("registerIdx") Long registerIdx, Model model) {

        Register register = registerService.findOne(registerIdx);

        model.addAttribute("register", register);
        return "ani/detail";

    }


    //등록한 동물정보 삭제
    @PostMapping("/delete")
    public String deleteAni(@RequestParam("registerIdx") Long registerIdx ) {
        registerService.deleteAni(registerIdx);
        return "redirect:/ani/list";
    }

    @RequestMapping("/find")
    public @ResponseBody String findByAniId(String aniId) {
        Register result = registerService.findByAniId(aniId);
        String resultAniName = result.getAniName();
        String resultKind = result.getKind();
        String resultWeight = result.getWeight();
        String resultColor = result.getColor();
        String resultBirth = result.getBirth();
        String strResult = resultAniName + "," + resultKind +  "," + resultWeight + "," + resultColor + "," + resultBirth;
        System.out.println(strResult);
        return strResult;
    }
    @RequestMapping("/findByPhone")
    public @ResponseBody List<Register> findByPhone(String phone) {
        List<Register> result = registerService.findByPhone(phone);

        for (int i = 0; i <result.size() ; i++) {
            String resultAniId = result.get(i).getAniId();

            System.out.println(resultAniId);
            return result;
        }
        return result;
    }


}