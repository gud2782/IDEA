package com.likeadog.idea.service;

import com.google.zxing.WriterException;
import com.likeadog.idea.api.NumberGen;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.repository.QrcodeRepository;
import org.hibernate.cache.internal.QueryResultsCacheImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class QrcodeServiceTest {


    @Autowired
    QrcodeService qrcodeService;

    @Autowired
    QrcodeRepository qrcodeRepository;

    @Test
    public void text2QRCodeWithUrl() throws WriterException, IOException {
        String contents = "http://172.30.1.3:8080/ani/new";
        int width = 200;
        int height = 200;
        String filename = "url_qrcode.png";

        qrcodeService.text2QRCode(contents, width, height, filename);
    }

    @Test
    @Rollback(value = false)
    public void runGenLoop() {
        List<String> list = NumberGen.genLoop();

        for (int i = 0; i < list.size(); i++) {
            Qrcode qrcode = Qrcode.builder()
                    .bNumber(list.get(i))
                    .build();

            System.out.println("test" + qrcode.getBNumber());

            qrcodeRepository.regQr(qrcode);
        }


    }
}
