package com.likeadog.idea.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.likeadog.idea.api.NumberGen;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.repository.QrcodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public static void text2QRCode(String contents, int width, int height,
                                   String filename) throws WriterException, IOException {
        BitMatrix bitMatrix = createBitMatrix(contents, width, height);
        MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(filename));
    }

    public static void text2QRCode(String contents, int width, int height,
                                   OutputStream os) throws WriterException, IOException {
        BitMatrix bitMatrix = createBitMatrix(contents, width, height);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
    }

    private static BitMatrix createBitMatrix(String contents, int width,
                                             int height) throws UnsupportedEncodingException, WriterException {
        contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(contents,
                BarcodeFormat.QR_CODE, width, height);
        return bitMatrix;
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


}

