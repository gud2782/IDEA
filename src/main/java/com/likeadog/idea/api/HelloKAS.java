package com.likeadog.idea.api;

/*
컨트랙트에서 값 받아올때 struct, boolean 타입은 아래 타입으로 호환시킬 것.
 */
import com.klaytn.caver.abi.datatypes.DynamicStruct; // 스마트 컨트랙트의 struct 호환
import com.klaytn.caver.abi.datatypes.Bool; // 스마트 컨트랙트의 bool 타입 호환

import com.klaytn.caver.abi.datatypes.Type;
import com.klaytn.caver.methods.response.Quantity;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import jnr.ffi.Struct;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.groundx.caver_ext_kas.CaverExtKAS;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.klaytn.caver.contract.Contract;
import com.klaytn.caver.contract.SendOptions;
import com.klaytn.caver.methods.response.TransactionReceipt;
import com.klaytn.caver.utils.ChainId;
import org.web3j.protocol.exceptions.TransactionException;
import xyz.groundx.caver_ext_kas.CaverExtKAS;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class HelloKAS {


    private static String chainId;
    private static String accessKeyId;
    private static String secretAccessKey ;

    public HelloKAS() throws IOException {
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

    static byte[] bytes;

    static {
        try {
            bytes = Files.readAllBytes(Paths.get("C:\\Users\\lhn14\\Desktop\\merge\\IDEA\\src\\main\\java\\com\\likeadog\\idea\\api\\Abi"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static final String ABI = new String(bytes);

    static final String CA = "0xAD911989917A394fd8b3f90D19f7E83188d5C626";

    public static void getBlockNumber() throws IOException {
        CaverExtKAS caver = new CaverExtKAS();


        caver.initKASAPI(chainId, accessKeyId, secretAccessKey);

        Quantity response = caver.rpc.klay.getBlockNumber().send();
        System.out.println(response.getResult());

    }

    @GetMapping("/pet/info")
    public static ResponseEntity test(@RequestParam("did") String did) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        System.out.println(did);
        //did:peterpet:c0f7f26d01
        CaverExtKAS caver = new CaverExtKAS(chainId, accessKeyId, secretAccessKey);

        String executor = "0x970B4581F63093aB145B0490914a43E39d979D16";



        Contract contract = new Contract(caver, ABI, CA);
        List<Type> result = contract.call("getAllInfoByDid",did);
        List<Type> isNeutering = contract.call("getPetIsNeuteringByDid",did);
        boolean check = (boolean)isNeutering.get(0).getValue();

        ArrayList<DynamicStruct> peterpet = (ArrayList<DynamicStruct>) result.get(0).getValue();
//        String result1 =  result.get(0).;
//        String result1 =  (String.valueOf(peterpet.get(0)));
//        String name = (String.valueOf(peterpet.get(1)));
//        String kind = (String.valueOf(peterpet.get(2)));
//        String gender = (String.valueOf(peterpet.get(3)));
//        String birth = (String.valueOf(peterpet.get(4)));
//        String color = (String.valueOf(peterpet.get(7)));
//        System.out.println(name + "," + kind + "," + gender + "," + birth + "," + color );



        HashMap<String, Object> peterpetList = new HashMap<String, Object>();
        peterpetList.put("img", (String.valueOf(peterpet.get(0))));
        peterpetList.put("name" , (String.valueOf(peterpet.get(1))));
        peterpetList.put("kind", (String.valueOf(peterpet.get(2))));
        peterpetList.put("gender", (String.valueOf(peterpet.get(3))));
        peterpetList.put("birth", (String.valueOf(peterpet.get(4)))); //com.klaytn.caver.abi.datatypes.Bool
        peterpetList.put("isNeutering", check);
        peterpetList.put("color", (String.valueOf(peterpet.get(7))));



        return ResponseEntity.ok(peterpetList);
//        String resultset = result + "," +




//        try{
//            JsonArray jsonArray = new JsonArray();
//            obj.put("peterpet",peterpet);
//        }catch (JsonIOException e){
//            e.printStackTrace();
//        }


        /*
            0 string imgHash; // img IPFS 값
        1 string name; // 이름
        2 string breedOfDog; // 견종
        3 string gender; //성별
        4 string birth; //생년월일
            5 string adoptionDate; // 입양일
            6 bool isNeutering; // 중성화 여부
        7 string furColor; //모색
            8 string[] vaccinationHistory; //접종내역
            9 string notes; //특이사항
            10 bool missing; //실종상태
            11 string paNftId;
         */


    }







}