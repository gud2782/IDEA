package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@SequenceGenerator(name = "Qrcode_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Qrcode extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Qrcode_SEQ_Generator")
    private Long qrcodeIdx;

    private String bNumber; //혈액번호
    private String url; //url


//    @OneToOne(mappedBy = "qrcode")
//    private Transfusion transfusion;
//
//    @OneToOne(mappedBy = "qrcode")
//    private Donation donation;
}
