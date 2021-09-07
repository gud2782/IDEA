package com.likeadog.idea.controller;

import com.likeadog.idea.service.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/donation")
public class DonationController {

    private final DonationService donationService;

    @GetMapping("/new")
    public String donationNew() {

        return "donation/new";
    }

    @GetMapping("/list")
    public void donationList() {

    }

    @GetMapping("/update")
    public void donationUpdate() {

    }


}
