package com.likeadog.idea.controller;

import com.google.zxing.WriterException;
import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@AllArgsConstructor
public class QrcodeController {

    private final QrcodeService qrcodeService;


    //혈액 등록
    @RequestMapping("qr/{qrcodeIdx}")
    public String text2QRCode(@PathVariable("qrcodeIdx") String qrcodeIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.3:8080/ani/new";
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();
        return "qr/create";
    }


}

