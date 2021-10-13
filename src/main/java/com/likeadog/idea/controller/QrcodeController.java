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
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.String;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    @RequestMapping("qr")
    public String makeqr(HttpServletRequest request, HttpSession session, String storeName) throws WriterException, IOException {

        String root = request.getSession().getServletContext().getRealPath("resources"); //현재 서비스가 돌아가고 있는 서블릿 경로의 resources 폴더 찾기

        String savePath = root + "\\qrCodes\\"; // 파일 경로

        System.out.println("savePath : "+ savePath);
        //파일 경로가 없으면 생성하기
        File file = new File(savePath);
        if(!file.exists()) {
            file.mkdirs();
        }

        // 링크로 할 URL주소
        String url = "localhost:8800/jhpay/enterStore.do?store="+storeName;

        // 링크 생성값
        String codeurl = new String(url.getBytes("UTF-8"), "ISO-8859-1");

        // QRCode 색상값
        int qrcodeColor =   0xFF2e4e96;
        // QRCode 배경색상값
        int backgroundColor = 0xFFFFFFFF;

        //QRCode 생성
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE,200, 200);    // 200,200은 width, height

        MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);

        //파일 이름에 저장한 날짜를 포함해주기 위해 date생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName=sdf.format(new Date()) +storeName;

        //파일 경로, 파일 이름 , 파일 확장자에 맡는 파일 생성
        File temp =  new File(savePath+fileName+".png");

        // ImageIO를 사용하여 파일쓰기
        ImageIO.write(bufferedImage, "png",temp);

        //리턴은 사용자가 원하는 값을 리턴한다.
        //작성자는 QRCode 파일의 이름을 넘겨주고 싶었음.
        return fileName+".png";
    }




}

