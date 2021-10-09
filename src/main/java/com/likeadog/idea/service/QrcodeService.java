package com.likeadog.idea.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.likeadog.idea.api.NumberGen;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.repository.QrcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QrcodeService {

    private final QrcodeRepository qrcodeRepository;
    private static String address = "172.30.1.45";

    public void registerQrcode(Long registerIdx) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("C:\\qrtest\\animals");
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = "http://" + address + ":8080/ani/"+registerIdx+"/detail";

            // 큐알코드 바코드 생상값
            int qrcodeColor =   0xFF766c15;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,200, 200);
            //
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            // ImageIO를 사용한 바코드 파일쓰기
            ImageIO.write(bufferedImage, "png", new File("C:\\qrtest\\animals\\"+ registerIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void donationQrcode(Long donationIdx) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("C:\\qrtest\\donation");
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = "http://" + address + ":8080/donation/"+donationIdx+"/detail";

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
            ImageIO.write(bufferedImage, "png", new File("C:\\qrtest\\donation\\"+ donationIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transfusionQrcode(Long transfusionIdx) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("C:\\qrtest\\transfusion");
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = "http://" + address + ":8080/transfusion/"+transfusionIdx+"/detail";

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
            ImageIO.write(bufferedImage, "png", new File("C:\\qrtest\\transfusion\\"+ transfusionIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void vaccineQrcode(Long vaccineIdx) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("C:\\qrtest\\vaccine");
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소

            String text = "http://" + address + ":8080/vc/"+vaccineIdx+"/detail";

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
            ImageIO.write(bufferedImage, "png", new File("C:\\qrtest\\vaccine\\"+ vaccineIdx+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void makeBnumbers(){

        List<String> list= NumberGen.genLoop();

        for (int i = 0; i <list.size(); i++) {
            Qrcode qrcode = Qrcode.builder()
                    .bNumber(list.get(i))
                    .build();
            qrcodeRepository.regQr(qrcode);
        }


    }

    public void bNumberQrcode(Long bNumber) {
        try {
            File file = null;

            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("C:\\qrtest\\blood");
            if(!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소
            String text = "http://" + address + ":8080/transfusion/new";


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
            ImageIO.write(bufferedImage, "png", new File("C:\\qrtest\\blood\\"+ bNumber+ "qrcode.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

