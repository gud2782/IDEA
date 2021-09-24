package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.FirstEnum;
import com.likeadog.idea.enumCollection.SecondEnum;
import com.likeadog.idea.enumCollection.ThirdEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Vinfo {
    @Id @GeneratedValue
    private Long vInfoIdx;

    @Enumerated(EnumType.STRING)
    private FirstEnum first; //대분류 [혼합 / 코로나 / 기관,기관지염 / 광견병]

    @Enumerated(EnumType.STRING)
    private SecondEnum second; //중분류 [기초접종 / 추가접종 / 보강접종]

    @Enumerated(EnumType.STRING)
    private ThirdEnum third; //소분류 [홍역 / 간염 / 파보장염 / 파라인플루엔자 / 럽토스피라]

    @OneToMany(mappedBy = "vinfo")
    private List<VaccineVinfo> vaccines = new ArrayList<>();

}

