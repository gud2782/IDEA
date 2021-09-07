package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long user_idx;

    private String userId; //견주ID
    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String phone; //핸드폰번호

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime c_date; //생성날짜
    private LocalDateTime m_date; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부
}
