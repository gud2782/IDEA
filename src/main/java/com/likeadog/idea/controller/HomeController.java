package com.likeadog.idea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("index1")
    public String index1() {
        return "html/index_01";
    }


    @GetMapping("index2")
    public String index2() {
        return "html/index_02";
    }

    @GetMapping("home")
    public String home() {
        return "home/main";
    }

    @GetMapping("test")
    public String test() {
        return "ani/anitest";
    }

    @GetMapping("layout")
    public String layout() {

        return "fragments/layout";
    }
}
