package com.likeadog.idea.controller;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.likeadog.idea.service.QrcodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.String;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@AllArgsConstructor
public class QrcodeController {

    private final QrcodeService qrcodeService;


    private static String address = "172.30.1.33";



    //등록된 동물 정보 qr코드
    @GetMapping("ani/qr/r{registerIdx}")
    public void registerQrcode(@PathVariable("registerIdx") Long registerIdx)
            {
        qrcodeService.registerQrcode(registerIdx);


    }

    @GetMapping("donation/qr/d{donationIdx}")
    public void donationQrcod(@PathVariable("donationIdx") Long donationIdx){

            qrcodeService.donationQrcode(donationIdx);


    }
    @GetMapping("transfusion/qr/t{transfusionIdx}")
    public void transfusionQrcode(@PathVariable("transfusionIdx") Long transfusionIdx){

        qrcodeService.transfusionQrcode(transfusionIdx);


    }

    @GetMapping("vc/qr/v{vaccineIdx}")
    public void vaccineQrcode(@PathVariable("vaccineIdx") Long vaccineIdx){

        qrcodeService.vaccineQrcode(vaccineIdx);


    }

    @GetMapping("blood/qr/b{bNumber}")
    public void bNumberQrcod(@PathVariable("bNumber") Long bNumber){


        qrcodeService.bNumberQrcode(bNumber);




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

    @GetMapping("qr/main")
    public String qrMain() {
        return "qr/main";
    }

    @GetMapping("qr/list")
    public String qrList() {
        return "qr/list";
    }








    public void runGenLoop(){
        qrcodeService.makeBnumbers();
    }






}

