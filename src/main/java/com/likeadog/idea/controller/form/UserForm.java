package com.likeadog.idea.controller.form;


import com.likeadog.idea.enumCollection.DeleteStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserForm {


    @NotEmpty(message = "견주 아이디는 필수 입니다")
    private String userId; //견주ID

    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String phone; //핸드폰번호

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteStatus del; //삭제여부


}
