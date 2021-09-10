package com.likeadog.idea.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity{

    @Id
    @GeneratedValue
    private Long userIdx;

    private String userId; //견주ID
    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String phone; //핸드폰번호




    @OneToMany(mappedBy = "user")
    private List<Register> registers = new ArrayList<>();

}
