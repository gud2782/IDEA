package com.likeadog.idea.controller.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class RegisterForm {

    private Long registerIdx;

    @NotEmpty(message = "동물등록번호는 필수입니다.")
    private String aniId; //동물등록번호


    private String aniName; //동물이름
    private String weight; //몸무게
    private String kind; //견종
    private String color; //모색
    private String gender; //성별
    private String birth; //출생년도
    private String neutralization; //중성화

}
