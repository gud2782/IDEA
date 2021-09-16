package com.likeadog.idea.controller.form;


import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransfusionForm {


    private Long transfusionIdx;

    @NotEmpty(message = "동물등록번호를 입력하세요")
    private Register register;

    private Qrcode qrcode;

    private int tWeight; //수혈 당시 몸무게
    private String kind; //견종
    private LocalDate tDate; //수혈일시
    private String tHos; //수혈병원
    private String type; //혈액형
    private String tPack; //수혈양
    private char neutralization; //중성화

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

}
