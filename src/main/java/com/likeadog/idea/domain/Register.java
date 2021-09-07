package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Register {
    @Id
    @GeneratedValue
    private Long registerIdx;

    @ManyToOne
    @JoinColumn(name ="userIdx")
    private User user;

    private String aniId; //동물등록번호
    private String aniName; //동물이름
    private int weight; //몸무게
    private String kind; //견종
    private String color; //모색
    private char gender; //성별
    private LocalDate birth; //출생년도
    private char neutralization; //중성화

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

    @OneToMany(mappedBy = "register")
    private List<Donation> donations = new ArrayList<>();

    @OneToMany (mappedBy = "register")
    private List<Vaccine> vaccines  = new ArrayList<>();

    @OneToMany(mappedBy = "register")
    private List<Transfusion> transfusions = new ArrayList<>();
}
