package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transfusion extends BaseEntity{
    @Id
    @GeneratedValue
    private Long transfusionIdx;

    @ManyToOne
    @JoinColumn(name = "registerIdx")
    private Register register; //동물 등록번호를 가져옴

    @OneToOne
    @JoinColumn(name = "qrcodeIdx")
    private Qrcode qrcode; //혈액번호를 가져옴

    private int tWeight; //수혈 당시 몸무게
    private String kind; //견종
    private LocalDate tDate; //수혈일시
    private String tHos; //수혈병원
    private String type; //혈액형
    private String tPack; //수혈양
    private char neutralization; //중성화


}
