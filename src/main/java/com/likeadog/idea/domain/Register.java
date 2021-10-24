package com.likeadog.idea.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Register_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Register extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Register_SEQ_Generator")
    private Long registerIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="userIdx")
    private UserEntity user;

    private String aniId; //동물등록번호
    private String aniName; //동물이름
    private String weight; //몸무게
    private String kind; //견종
    private String color; //모색
    private String gender; //성별
    private String birth; //출생년도
    private String neutralization; //중성화
    private String fileName;
    private String hash;
    private String aniImg;



    @OneToMany (mappedBy = "register")
    @Builder.Default
    private List<RegisterVaccine> registerVaccines  = new ArrayList<>();


//    @OneToMany(mappedBy = "register")
//    private List<Donation> donations = new ArrayList<>();

//    @OneToMany(mappedBy = "register")
//    private List<Transfusion> transfusions = new ArrayList<>();



}
