package com.likeadog.idea.api;

import com.klaytn.caver.methods.response.Quantity;
import xyz.groundx.caver_ext_kas.CaverExtKAS;

import java.io.IOException;

public class HelloKAS {
    public static void getBlockNumber() throws IOException {
        CaverExtKAS caver = new CaverExtKAS();

        String chainId = "1001";
        String accessKeyId = "KASKR0A3C1P8ICQKD9WWII8S";
        String secretAccessKey = "fGyVhvQbyHuu7GuiuN5vyghvgeIO_qyyfXjaITVG";

        caver.initKASAPI(chainId, accessKeyId, secretAccessKey);

        Quantity response = caver.rpc.klay.getBlockNumber().send();
        System.out.println(response.getResult());
    }


}