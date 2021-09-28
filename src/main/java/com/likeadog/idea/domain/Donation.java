package com.likeadog.idea.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Donation_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Donation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Donation_SEQ_Generator")
    private Long donationIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "registerIdx")
    private Register register; //동물 등록번호를 가져옴

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "qrcodeIdx")
    private Qrcode qrcode; //혈액번호를 가져옴

    private String dWeight; //헌혈 당시 몸무게
    private String kind; //견종

    private String dDate; //헌혈일시
    private String dHos; //헌혈병원
    private String type; //혈액형
    private String dPack; //헌혈양
    private String neutralization; //중성화


}
