package com.likeadog.idea.api;

import com.klaytn.caver.methods.response.Quantity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.groundx.caver_ext_kas.CaverExtKAS;
import java.io.IOException;

@Component
public class HelloKAS {


    private static String chainId;
    private static String accessKeyId;
    private static String secretAccessKey ;


    public static void getBlockNumber() throws IOException {
        CaverExtKAS caver = new CaverExtKAS();


        caver.initKASAPI(chainId, accessKeyId, secretAccessKey);

        Quantity response = caver.rpc.klay.getBlockNumber().send();
        System.out.println(response.getResult());


    }

    //key-set
    @Value("${key.chainId}")
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }
    @Value("${key.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
    @Value("${key.secretAccessKey}")
    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

}