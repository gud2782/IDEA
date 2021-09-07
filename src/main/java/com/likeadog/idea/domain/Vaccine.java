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
public class Vaccine {
    @Id
    @GeneratedValue
    private Long vaccine_idx;

    @ManyToOne
    @JoinColumn(name = "register_idx")
    private Register register_idx; //동물 등록번호를 가져옴

    @ManyToOne
    @JoinColumn(name = "v_info_idx")
    private V_info v_info_idx; //백신정보idx 가져옴

    private String v_number; //차수
    private LocalDate v_date; //접종일
    private LocalDate n_date; //다음 접종일

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime c_date; //생성날짜
    private LocalDateTime m_date; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부
}
