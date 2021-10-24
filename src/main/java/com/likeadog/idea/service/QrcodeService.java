package com.likeadog.idea.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.likeadog.idea.api.NumberGen;
import com.likeadog.idea.controller.form.QrcodeForm;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.domain.Transfusion;
import com.likeadog.idea.dto.QrcodeDto;
import com.likeadog.idea.repository.QrcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QrcodeService {

    private final QrcodeRepository qrcodeRepository;
    @Autowired
    DonationService donationService;

    @Autowired
    TransfusionService transfusionService;

    private static String address = "172.30.1.51";


    public void registerQrcode(String aniId) {
        String text = aniId.substring(13,23);
        try {
            File file = null;


            // 큐알이미지를 저장할 디렉토리 지정
            String root = "C:\\Users\\lhn14\\Desktop\\merge\\IDEA\\src\\main\\resources\\static\\qrcode\\animals";
            file = new File(root);
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소
            String textQrcode = aniId;



            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFF766c15;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(textQrcode, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", new File(root+"\\"+ "peterpet_"+text+ ".png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void donationQrcode(Long donationIdx) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            String root = "C:\\Users\\lhn14\\Desktop\\merge\\IDEA\\src\\main\\resources\\static\\qrcode\\donation";
            file = new File(root;
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = String.valueOf(donationIdx);



            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFF2e4e96;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", new File(root+"\\"+ donationIdx+ ".png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transfusionQrcode(Long transfusionIdx) {
        try {
            String root = "C:\\Users\\lhn14\\Desktop\\merge\\IDEA\\src\\main\\resources\\static\\qrcode\\transfusion";
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File(root);
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = String.valueOf(transfusionIdx);

            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFF557615;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", new File(root+"\\"+ transfusionIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vaccineQrcode(Long vaccineIdx) {
        try {
            String root = "C:\\Users\\lhn14\\Desktop\\merge\\IDEA\\src\\main\\resources\\static\\qrcode\\vaccine";
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File(root);
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = String.valueOf(vaccineIdx);

            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFFad1004;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", new File(root+"\\"+ vaccineIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void makeBnumbers(){

        List<String> list= NumberGen.genLoop();

        for (int i = 0; i <list.size(); i++) {
            String genbNumber = list.get(i);


            try {
                String root = "C:\\RealFinalPrj\\IDEA\\src\\main\\resources\\static\\qrcode\\bNumber";
                File file = null;

                // 큐알이미지를 저장할 디렉토리 지정
                file = new File(root);
                if(!file.exists()) {
                    file.mkdirs();
                }
                // 코드인식시 링크걸 URL주소

                String text = genbNumber;

                // 큐알코드 바코드 생상값
                int qrcodeColor =   0xFFad1004;
                // 큐알코드 배경색상값
                int backgroundColor = 0xFFFFFFFF;

                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                // 3,4번째 parameter값 : width/height값 지정
                BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200, 200);
                //
                MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
                BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
                // ImageIO를 사용한 바코드 파일쓰기
                String bNumberPath = root+"\\"+genbNumber+ "qrcode.png";
                ImageIO.write(bufferedImage, "png", new File(bNumberPath));

                Qrcode qrcode = Qrcode.builder()
                        .bNumber(genbNumber)
                        .url(bNumberPath)
                        .build();
                qrcodeRepository.regQr(qrcode);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }


    public void saveDonation(String bNumber,String dosId, QrcodeForm form) {


        Qrcode qrcode = qrcodeRepository.findBybNumber(bNumber);
        Donation donation = donationService.findDonationByAniId(dosId);

        donation.setDPack(form.getDPack());
        donation.setDHos(form.getDHos());
        donation.setQrcode(qrcode);

        donationService.saveDonation(donation);



    }
    public void saveTransfusion(String bNumber,String transId, QrcodeForm form) {


        Qrcode qrcode = qrcodeRepository.findBybNumber(bNumber);
        Transfusion transfusion = transfusionService.findTransfusionByAniId(transId);

        transfusion.setTPack(form.getTPack());
        transfusion.setTHos(form.getTHos());
        transfusion.setQrcode(qrcode);


        transfusionService.saveTransfusion(transfusion);

    }

    public List<Qrcode> findQR() {
        return qrcodeRepository.findAll();
    }


    public List<QrcodeDto> getqrcodeDtos(){

        List<Qrcode> qrcodes = qrcodeRepository.findAll();
        List<QrcodeDto> qrcodeDtos = new ArrayList<>();
        for (int i = 0; i <qrcodes.size() ; i++) {
            qrcodeDtos.add(qrcodeRepository.getQrcodeDto(qrcodes.get(i).getQrcodeIdx()));
        }
        return qrcodeDtos;

    }
}