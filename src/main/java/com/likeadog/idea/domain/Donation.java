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
public class Donation {

    @Id @GeneratedValue
    private Long donationIdx;

    @ManyToOne
    @JoinColumn(name = "registerIdx")
    private Register register; //동물 등록번호를 가져옴

    @OneToOne
    @JoinColumn(name = "qrcodeIdx")
    private Qrcode qrcode; //혈액번호를 가져옴

    private int dWeight; //헌혈 당시 몸무게
    private String kind; //견종

    private LocalDate dDate; //헌혈일시
    private String dHos; //헌혈병원
    private String type; //혈액형
    private String dPack; //헌혈양
    private char neutralization; //중성화

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부





}
