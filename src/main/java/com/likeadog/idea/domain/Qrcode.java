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
    private Long qrcode_idx;

    private String b_number; //혈액번호
    private String url; //url

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime c_date; //생성날짜
    private LocalDateTime m_date; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부


}
