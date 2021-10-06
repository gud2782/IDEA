package com.likeadog.idea.controller;

import com.likeadog.idea.dto.UserDto;
import com.likeadog.idea.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;



    // 내 정보 페이지
    @GetMapping("/info")
    public String dispMyInfo() {

        return "user/myInfo";
    }

    //로그인 페이지
    @RequestMapping("/login")
    public String login() throws Exception{
        return "user/loginForm";
    }

    //로그인 성공화면 페이지
    @RequestMapping("/loginSuccess")
    public String loginMain() throws Exception{
        return "user/loginSuccess";
    }



    //로그인 에러
    @GetMapping("/loginError")
    public String loginError(){
        return "user/loginError";
    }

    //로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "user/logout";
    }


    //회원가입 페이지
    @GetMapping("/register")
    public String createUserForm(Model model){
        model.addAttribute("userForm",new UserDto());
        return "user/signUp";
    }

    //회원가입 페이지 입력
    @PostMapping("/register")
    public String createUser(@Valid UserDto form, BindingResult result) throws Exception {
        form.setRole("ROLE_USER");
        if(result.hasErrors()){
            return "user/signUp";
        }
        userService.createUser(form);

        return "redirect:/home";
    }

    //접근 거부 페이지 이동
    @GetMapping("/denied")
    public String dispDenied() {

        return "user/denied";
    }



    @GetMapping("/update")
    public void userUpdate() {

    }

    @GetMapping("/delete")
    public void userDelete() {
//        userService.delUser();
    }
}
