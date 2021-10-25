package com.likeadog.idea.controller.form;


import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Register;
import com.likeadog.idea.enumCollection.DeleteStatus;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransfusionForm {


    private Long transfusionIdx;

    private Register register;

    private Qrcode qrcode;

    private String tWeight; //수혈 당시 몸무게
    private String kind; //견종
    private String tDate; //수혈일시
    private String tHos; //수혈병원
    private String type; //혈액형
    private String tPack; //수혈양
    private String neutralization; //중성화
    private String hash;
    private String aniImg;

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteStatus del; //삭제여부

}
