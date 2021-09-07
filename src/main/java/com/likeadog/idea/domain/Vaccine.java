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
    private Long vaccineIdx;

    @ManyToOne
    @JoinColumn(name = "registerIdx")
    private Register register; //동물 등록번호를 가져옴

    @ManyToOne
    @JoinColumn(name = "vInfoIdx")
    private Vinfo vInfo; //백신정보idx 가져옴

    private String vNumber; //차수
    private LocalDate vDate; //접종일
    private LocalDate nDate; //다음 접종일

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부
}
