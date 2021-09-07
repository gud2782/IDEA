package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import com.likeadog.idea.enumCollection.FirstEnum;
import com.likeadog.idea.enumCollection.SecondEnum;
import com.likeadog.idea.enumCollection.ThirdEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class V_info {
    @Id @GeneratedValue
    private Long v_info_idx;

    @Enumerated(EnumType.STRING)
    private FirstEnum first; //대분류 [혼합 / 코로나 / 기관,기관지염 / 광견병]

    @Enumerated(EnumType.STRING)
    private SecondEnum second; //중분류 [기초접종 / 추가접종 / 보강접종]

    @Enumerated(EnumType.STRING)
    private ThirdEnum third; //소분류 [홍역 / 간염 / 파보장염 / 파라인플루엔자 / 럽토스피라]

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime c_date; //생성날짜
    private LocalDateTime m_date; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

}

