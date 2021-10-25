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
@SequenceGenerator(name = "Transfusion_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Transfusion extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Transfusion_SEQ_Generator")
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
    private String hash;


}
