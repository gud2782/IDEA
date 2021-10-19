package com.likeadog.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String home() {
        return "home/main";
    }

    @GetMapping("/layout")
    public String index() {
        return "user/index";
    }

        @GetMapping("/qr/read")
    public String layout() {
        return "qr/read";
    }


    @GetMapping("/admin")
    public String admin() {
        return "user/admin";
    }

    @GetMapping("/manager")
    public String manager() {
        return "user/manager";
    }

    @GetMapping("/user")
    public String user() {
        return "user/user";
    }

    @GetMapping("/home/animals")
    public String animals() {
        return "home/animals";
    }

    @GetMapping("/home/donation")
    public String donation() {
        return "home/donation";
    }

    @GetMapping("/home/transfusion")
    public String transfusion() {
        return "home/transfusion";
    }

    @GetMapping("/home/blood")
    public String blood() {
        return "home/blood";
    }


}
