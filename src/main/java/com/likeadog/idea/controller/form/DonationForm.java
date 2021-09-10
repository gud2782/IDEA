package com.likeadog.idea.controller.form;


import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
public class DonationForm {


    @NotEmpty(message = "동물등록번호를 입력하세요")

    private int dWeight; //헌혈 당시 몸무게
    private String kind; //견종

    private LocalDate dDate; //헌혈일시
    private String dHos; //헌혈병원
    private String type; //혈액형
    private String dPack; //헌혈양
    private char neutralization; //중성화

}
