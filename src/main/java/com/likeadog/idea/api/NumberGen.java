package com.likeadog.idea.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGen {

    public static String numberGen() {

        Random rand = new Random();
        String numStr = ""; //난수가 저장될 변수



            for (int j = 0; j < 6; j++) {

                //0~9 까지 난수 생성
                String ran = Integer.toString(rand.nextInt(10));

                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if (!numStr.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                    numStr += ran;

                } else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    j -= 1;
                }
            }



        return numStr;
    }

    public static String numberGenLoop() {
        for (int i = 0; i < 10; i++) {
            System.out.println(numberGen());
        }
        return numberGen();
    }
    public static List<String> genLoop() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(numberGen());
        }
        return list;
    }


}
