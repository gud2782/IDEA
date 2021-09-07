package com.likeadog.idea.controller;

import com.likeadog.idea.service.VaccineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/vc")
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping("/new")
    public void vaccineNew() {

    }

    @GetMapping("/list")
    public void vaccineList() {

    }

    @GetMapping("/update")
    public void vaccineUpdate() {

    }

    @GetMapping("/delete")
    public void vaccineDelete() {

    }

}
