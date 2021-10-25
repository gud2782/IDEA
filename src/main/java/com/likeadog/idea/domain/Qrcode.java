package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.BloodStatus;
import com.likeadog.idea.enumCollection.DeleteStatus;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Qrcode_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Qrcode extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Qrcode_SEQ_Generator")
    private Long qrcodeIdx;

    private String bNumber; //혈액번호
    private String url; //qr코드 url


    @OneToOne(mappedBy = "qrcode")
    private Transfusion transfusion;

    @OneToOne(mappedBy = "qrcode")
    private Donation donation;


    private String bloodStatus; //혈액상태
    private String dhash;
    private String thash;

}
