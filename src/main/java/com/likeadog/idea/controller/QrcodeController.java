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


    //등록된 동물 정보 qr코드
    @GetMapping("qr/r{registerIdx}")
    public void registerQrcod(@PathVariable("registerIdx") String registerIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.60:8080/ani/"+registerIdx+"/detail";
//        172.30.1.60 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("qr/d{donationIdx}")
    public void donationQrcod(@PathVariable("donationIdx") String donationIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.60:8080/donation/"+donationIdx+"/detail";
//        172.30.1.16 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }
    @GetMapping("qr/t{transfusionIdx}")
    public void transfusionQrcod(@PathVariable("transfusionIdx") String transfusionIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.60:8080/transfusion/"+transfusionIdx+"/detail";
//        172.30.1.16 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("qr/v{vaccineIdx}")
    public void vaccineQrcod(@PathVariable("vaccineIdx") String vaccineIdx,
                                 HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.60:8080/vc/"+vaccineIdx+"/detail";
//        172.30.1.16 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("qr/b{bNumber}")
    public void bNumberQrcod(@PathVariable("bNumber") String bNumber,
                             HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://172.30.1.60:8080/transfusion/new";
//        172.30.1.16 집
//        192.168.0.28 가산
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }



    public void runGenLoop(){
        qrcodeService.makeBnumbers();
    }






}

