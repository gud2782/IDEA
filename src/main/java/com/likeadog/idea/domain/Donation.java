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
    private Long donation_idx;

    @ManyToOne
    @JoinColumn(name = "register_idx")
    private Register register_idx; //동물 등록번호를 가져옴

    @ManyToOne
    @JoinColumn(name = "qrcode_idx")
    private Qrcode qrcode_idx; //혈액번호를 가져옴

    private int d_weight; //헌혈 당시 몸무게
    private String kind; //견종

    private LocalDate d_date; //헌혈일시
    private String d_hos; //헌혈병원
    private String type; //혈액형
    private String d_pack; //헌혈양
    private char neutralization; //중성화

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime c_date; //생성날짜
    private LocalDateTime m_date; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부





}
