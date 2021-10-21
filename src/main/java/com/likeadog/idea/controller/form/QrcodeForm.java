package com.likeadog.idea.controller.form;

import com.likeadog.idea.domain.BaseEntity;
import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Transfusion;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrcodeForm{
    private Long qrcodeIdx;


    private String bNumber; //혈액번호
    private String url; //qr코드 url

    //추가
    String tHos; //수혈 병원
    String dHos; //헌혈 병원

    String dPack; //헌혈 양
    String tPack; //수혈 양




    private Transfusion transfusion;

    private Donation donation;
}