//package com.likeadog.idea.api;
//
//import com.klaytn.caver.methods.response.Quantity;
//import xyz.groundx.caver_ext_kas.CaverExtKAS;
//
//
//import java.io.IOException;
//
//public class HelloKAS {
//    public static void getBlockNumber() throws IOException {
//        CaverExtKAS caver = new CaverExtKAS();
//        caver.initKASAPI("1001", "KASKR0A3C1P8ICQKD9WWII8S", "fGyVhvQbyHuu7GuiuN5vyghvgeIO_qyyfXjaITVG");
////        caver.initKASAPI(chainId, accessKeyId, secretAccessKey);
//
//        Quantity response = caver.rpc.klay.getBlockNumber().send();
//        System.out.println(response.getResult());
//    }
//
//    public static void main(String[] args) throws IOException {
//        getBlockNumber();
//    }
//}