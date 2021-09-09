package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Qrcode extends BaseEntity{
    @Id @GeneratedValue
    private Long qrcodeIdx;

    private String bNumber; //혈액번호
    private String url; //url


    @OneToOne(mappedBy = "qrcode")
    private Transfusion transfusion;

    @OneToOne(mappedBy = "qrcode")
    private Donation donation;
}
