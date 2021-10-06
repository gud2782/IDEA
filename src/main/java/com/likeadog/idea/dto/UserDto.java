package com.likeadog.idea.dto;


import com.likeadog.idea.domain.UserEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private Long userIdx;


    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId; //견주ID
    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String phone; //핸드폰번호

    private String role;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userIdx(userIdx)
                .userId(userId)
                .pw(pw)
                .name(name)
                .address(address)
                .phone(phone)
                .role(role)
                .build();
    }

    @Builder
    public UserDto(Long userIdx, String userId, String pw, String name, String address, String phone, String role) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }
}
