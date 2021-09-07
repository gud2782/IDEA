package com.likeadog.idea.controller;

import com.likeadog.idea.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "ani")
public class RegisterController {

    private final RegisterService registerService;
    @GetMapping("/new")
    public void aniNew() {

    }

    @GetMapping("/list")
    public void aniList() {

    }

    @GetMapping("/update")
    public void aniUpdate() {

    }
}
