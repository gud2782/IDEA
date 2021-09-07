package com.likeadog.idea.controller;

import com.likeadog.idea.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/register")
    public void userRegister() {

    }

    @GetMapping("/update")
    public void userUpdate() {

    }

    @GetMapping("/delete")
    public void userDelete() {

    }
}
