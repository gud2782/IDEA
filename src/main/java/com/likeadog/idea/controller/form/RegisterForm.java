package com.likeadog.idea.controller.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class RegisterForm {


    @NotEmpty(message = "동물등록번호를 입력하세요")
    private String aniId; //동물등록번호
    private String aniName; //동물이름
    private int weight; //몸무게
    private String kind; //견종
    private String color; //모색
    private char gender; //성별
    private LocalDate birth; //출생년도
    private char neutralization; //중성화

}
