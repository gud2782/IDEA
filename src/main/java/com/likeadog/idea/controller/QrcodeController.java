package com.likeadog.idea.controller;

import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "qr")
public class QrcodeController {

    private final QrcodeService qrcodeService;

    @GetMapping("/create")
    public void qrCreate() {

    }

    @GetMapping("/read")
    public void qrRead() {

    }

    @GetMapping("/insert")
    public void qrInsert() {

    }
}
