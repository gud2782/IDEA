package com.likeadog.idea.dto;

import com.likeadog.idea.domain.Donation;
import com.likeadog.idea.domain.Qrcode;
import com.likeadog.idea.domain.Transfusion;
import lombok.*;


@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class QrcodeDto {

    String bNumber;

    String daniId;
    String daniName;
    String dDate;
    String dPack;
    String dType;
    String dHos;

    String taniId;
    String taniName;
    String tDate;
    String tPack;
    String tType;
    String tHos;



}