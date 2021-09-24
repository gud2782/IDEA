package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Transfusion extends BaseEntity{
    @Id
    @GeneratedValue
    private Long transfusionIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "registerIdx")
    private Register register; //동물 등록번호를 가져옴

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "qrcodeIdx")
    private Qrcode qrcode; //혈액번호를 가져옴

    private String tWeight; //수혈 당시 몸무게
    private String kind; //견종
    private String tDate; //수혈일시
    private String tHos; //수혈병원
    private String type; //혈액형
    private String tPack; //수혈양
    private String neutralization; //중성화


}
