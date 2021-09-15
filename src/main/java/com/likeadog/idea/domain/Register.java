package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Register extends BaseEntity{
    @Id
    @GeneratedValue
    private Long registerIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="userIdx")
    private User user;

    private String aniId; //동물등록번호
    private String aniName; //동물이름
    private String weight; //몸무게
    private String kind; //견종
    private String color; //모색
    private String gender; //성별
    private String birth; //출생년도
    private String neutralization; //중성화

    @OneToMany (mappedBy = "register")
    private List<Register_Vaccine> register_vaccines  = new ArrayList<>();


//    @OneToMany(mappedBy = "register")
//    private List<Donation> donations = new ArrayList<>();

//    @OneToMany(mappedBy = "register")
//    private List<Transfusion> transfusions = new ArrayList<>();



}
