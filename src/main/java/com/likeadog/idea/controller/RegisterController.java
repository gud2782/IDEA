package com.likeadog.idea.controller;

import com.likeadog.idea.api.PublicAPI;
import com.likeadog.idea.controller.form.RegisterForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.dto.FindByPhoneResponseDto;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.service.DonationService;
import com.likeadog.idea.service.RegisterService;
import com.likeadog.idea.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "ani")
public class RegisterController {

    private final RegisterService registerService;
    private final UserService userService;

    @Autowired
    PublicAPI publicAPI;


    //API 활용
    @ResponseBody
    @GetMapping("/callAPI")
    public String callAPI(String aniId,String name){

        return publicAPI.callAPI(aniId,name);

    }



    //동물정보 등록
    @GetMapping("/new")
    public String createForm(Model model){

        UserEntity userEntity = userService.findByUserID(SecurityInfoProvider.getCurrentMemberId());

        RegisterForm registerForm = new RegisterForm();
        registerForm.setUser(userEntity);

        model.addAttribute("registerForm", registerForm);
        return "ani/createRegisterFormWithAPI";
    }




    @PostMapping("/new")
    public String create(@RequestParam("aniId") String aniId,
                         @Valid RegisterForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "ani/createRegisterFormWithAPI";
        }
        System.out.println("get Hash : " + form.getHash());
        System.out.println("get aniName : " + form.getAniName());
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

        //String aniId = register.getAniId().substring(13,23);
        String aniId = register.getAniId();

        model.addAttribute("register", register);
        return "ani/detail";

    }


    //등록한 동물정보 삭제
    @PostMapping("/delete")
    public String deleteAni(@RequestParam("registerIdx") Long registerIdx ) {
        registerService.deleteAni(registerIdx);
        return "redirect:/ani/list";
    }

    @PostMapping("/find")
    public @ResponseBody String findByAniId( String aniId) {
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

    @ResponseBody
    @RequestMapping("/findByPhone")
    public List<FindByPhoneResponseDto> findByPhone(String phone) {
        List<Register> result = registerService.findByPhone(phone);
        List<FindByPhoneResponseDto> findByPhoneResponseDtos = new ArrayList<>();

        for (int i = 0; i <result.size(); i++) {
            FindByPhoneResponseDto findByPhoneResponseDto = FindByPhoneResponseDto.builder()
                    .aniId(result.get(i).getAniId())
                    .aniName(result.get(i).getAniName())
                    .color(result.get(i).getColor())
                    .kind(result.get(i).getKind())
                    .build();
            findByPhoneResponseDtos.add(findByPhoneResponseDto);
        }
        return findByPhoneResponseDtos;
    }

}