package com.likeadog.idea.controller;

import com.likeadog.idea.service.TransfusionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "transfusion")
public class TransfusionController {

    private final TransfusionService transfusionService;

    @GetMapping("/new")
    public void transfusionNew() {

    }

    @GetMapping("/list")
    public void transfusionList() {

    }

    @GetMapping("/update")
    public void transfusionUpdate() {

    }
}
