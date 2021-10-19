package com.likeadog.idea.controller;

import com.likeadog.idea.config.CustomAuthenticationProvider;
import com.likeadog.idea.controller.form.DonationForm;
import com.likeadog.idea.dto.UserDto;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;



    // 내 정보 페이지
    @GetMapping("/info")
    public String dispMyInfo() {

        return "user/myInfo1";
    }

    //로그인 페이지
    @RequestMapping("/login")
    public String login() throws Exception{
        System.out.println(SecurityInfoProvider.getCurrentUserType());
        return "user/loginForm";

    }


    //로그인 성공화면 페이지
    @RequestMapping("/loginSuccess")
    public String loginMain() throws Exception{
        return "redirect:/home";
    }



    //로그인 에러
    @GetMapping("/loginError")
    public String loginError(){
        return "user/loginError";
    }

    //로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/home";
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
        System.out.println(form.getUserId());

        return "redirect:/home";
    }


    //회원가입 페이지 입력
    @PostMapping("/register_hos")
    public String createhos(@Valid UserDto form, BindingResult result) throws Exception {
        form.setRole("ROLE_HOS");
        if(result.hasErrors()){
            return "user/signUp";
        }
        userService.createUser(form);
        System.out.println(form.getUserId());

        return "redirect:/home";
    }

    @GetMapping("/register_kakao")
    public String createUserKakao(@RequestParam("userId") String id,
                                  @RequestParam("kakaoName") String name
            , Model model) {

        if (userService.checkDuplicateId(id)==0) {
            System.out.println(id + name);
            UserDto userDto = UserDto.builder()
                    .userId(id)
                    //.pw("kakao")
                    .name(name)
                    .build();

            model.addAttribute("kakaoForm", userDto);
            return "user/signUp_kakao";
            }  else{

            String password = "kakao";

            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER_ROLE"));

            //토근 생성 방법을 생성하면서 토큰을 생성
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id,password,roles);

            /*public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
                super(null);
                this.principal = principal; //접근주체
                this.credentials = credentials; //비밀번호
                setAuthenticated(false);*/

            //새롭게 생성된 토큰을 통해 인증하면서 authentication 뽑아냄 //인증과정
            Authentication authentication = customAuthenticationProvider.authenticate(authenticationToken);

            //holder에 올리기위해서 뽑은 authentication을 여기에 넣어줌  //로그인 과정 --로그인 처리
            //로그인을 하는 순간 holder에 authentication이 올라감
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "redirect:/home";
        }




    }

    @PostMapping("/register_kakao")
    public String createKakao(@Valid UserDto form, BindingResult result) throws Exception {
        System.out.println(11111);
        form.setRole("ROLE_USER");
        form.setPw("kakao");
        System.out.println(form.getPw());
        userService.createUser(form);
        return "user/loginForm";
    }



    //접근 거부 페이지 이동
    @GetMapping("/denied")
    public String dispDenied() {

        return "user/denied";
    }



    @GetMapping("/update")
    public void userUpdate() {

    }

    //회원탈퇴 후 로그아웃 처리 복붙
    @GetMapping("/delete")
    public String userDelete(HttpServletRequest request, HttpServletResponse response) {
        userService.delUser();


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "user/logout";

    }
}
