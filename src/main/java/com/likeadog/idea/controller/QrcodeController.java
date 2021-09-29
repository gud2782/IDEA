package com.likeadog.idea.controller;


import com.google.zxing.WriterException;
import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@AllArgsConstructor
public class QrcodeController {

    private final QrcodeService qrcodeService;


    //반려동물등록 조회
    @GetMapping("qr/{qrcodeIdx}")
    public void text2QRCode(@PathVariable("qrcodeIdx") String qrcodeIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.16.101.8:8080/ani/"+qrcodeIdx+"/detail";
//        172.30.1.16 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();



      //  return "qr/create";
    }


    public void runGenLoop(){
        qrcodeService.makeBnumbers();
    }






}

