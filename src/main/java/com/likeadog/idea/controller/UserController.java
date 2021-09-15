package com.likeadog.idea.controller;

import com.likeadog.idea.controller.form.UserForm;
import com.likeadog.idea.domain.User;

import com.likeadog.idea.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/register")
    public String createForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "user/createUserForm";
    }

    @PostMapping("/register")
    public String create(@Valid UserForm form, BindingResult result){

        if (result.hasErrors()) {
            return "user/createUserForm";
        }

        User user = new User();
        user.setUserId(form.getUserId());
        user.setPw(form.getPw());
        user.setName(form.getName());
        user.setAddress(form.getAddress());
        user.setPhone(form.getPhone());

        userService.join(user);

        return "redirect:/main";

    }



    @GetMapping("/update")
    public void userUpdate() {

    }

    @GetMapping("/delete")
    public void userDelete() {

    }
}
