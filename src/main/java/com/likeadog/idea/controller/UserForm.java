package com.likeadog.idea.controller;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserForm {


    @NotEmpty(message = "견주 아이디는 필수 입니다")
    private String userId; //견주ID

    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String phone; //핸드폰번호


}
