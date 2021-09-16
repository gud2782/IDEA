package com.likeadog.idea.controller.form;


import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DonationForm {


    private Long donationIdx;

    @NotEmpty(message = "동물등록번호를 입력하세요")
    private Register register;

    private Qrcode qrcode;

    private String dWeight; //헌혈 당시 몸무게
    private String kind; //견종

    private String dDate; //헌혈일시
    private String dHos; //헌혈병원
    private String type; //혈액형
    private String dPack; //헌혈양
    private String neutralization; //중성화

    private String creater; //생성자
    private String modifier; //수정자
    private String cDate; //생성날짜
    private String mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

}