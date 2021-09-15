package com.likeadog.idea.service;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class QrcodeServiceTest {


    @Test
    public void text2QRCodeWithUrl() throws WriterException, IOException {
        String contents = "http://172.30.1.3:8080/ani/new";
        int width = 200;
        int height = 200;
        String filename = "url_qrcode.png";

        QrcodeService.text2QRCode(contents, width, height, filename);
    }



}