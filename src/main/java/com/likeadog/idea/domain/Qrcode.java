package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Qrcode {
    @Id @GeneratedValue
    private Long qrcodeIdx;

    private String bNumber; //혈액번호
    private String url; //url

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

    @OneToOne(mappedBy = "qrcode")
    private Transfusion transfusion;

    @OneToOne(mappedBy = "qrcode")
    private Donation donation;
}
