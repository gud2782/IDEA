package com.likeadog.idea.controller;


import com.google.zxing.WriterException;
import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.String;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@AllArgsConstructor
public class QrcodeController {

    private final QrcodeService qrcodeService;

    //        172.30.1.16 집
    //        192.168.0.28 가산
    //        172.30.1.33 구로
    private static String address = "172.30.1.33";



    //등록된 동물 정보 qr코드
    @GetMapping("ani/qr/r{registerIdx}")
    public void registerQrcod(@PathVariable("registerIdx") String registerIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://" + address + ":8080/ani/"+registerIdx+"/detail";
        System.out.println(address);
        System.out.println(text);
        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("donation/qr/d{donationIdx}")
    public void donationQrcod(@PathVariable("donationIdx") String donationIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://" + address + ":8080/donation/"+donationIdx+"/detail";
        System.out.println(text);

        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }
    @GetMapping("transfusion/qr/t{transfusionIdx}")
    public void transfusionQrcod(@PathVariable("transfusionIdx") String transfusionIdx,
                              HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://" + address + ":8080/transfusion/"+transfusionIdx+"/detail";
        System.out.println(text);

        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("vc/qr/v{vaccineIdx}")
    public void vaccineQrcod(@PathVariable("vaccineIdx") String vaccineIdx,
                                 HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://" + address + ":8080/vc/"+vaccineIdx+"/detail";
        System.out.println(text);

        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("blood/qr/b{bNumber}")
    public void bNumberQrcod(@PathVariable("bNumber") String bNumber,
                             HttpServletResponse response)
            throws IOException, WriterException {
        int width = 200;
        int height = 200;
        String text = "http://" + address + ":8080/transfusion/new";
        System.out.println(text);

        ServletOutputStream sos = response.getOutputStream();
        QrcodeService.text2QRCode(text, width, height, sos);
        sos.flush();
        sos.close();


    }

    @GetMapping("qr/main")
    public String main() {
        return "qr/main";
    }

    @GetMapping("qr/donation")
    public String qrDonation() {
        return "qr/createDonationForm";
    }

    @PostMapping("qr/donation")
    public String qrDonationForm() {
        return "qr/list";
    }

    @GetMapping("qr/transfusion")
    public String qrTransfusion() {
        return "qr/createTransfusionForm";
    }

    @PostMapping("qr/transfusion")
    public String qrTansfusionForm() {
        return "qr/list";
    }

    @GetMapping("qr/list")
    public String qrList() {
        return "qr/list";
    }






    public void runGenLoop(){
        qrcodeService.makeBnumbers();
    }






}

