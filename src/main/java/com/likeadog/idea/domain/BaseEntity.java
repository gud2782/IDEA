package com.likeadog.idea.domain;

import com.likeadog.idea.enumCollection.DeleteStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class    BaseEntity {

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteStatus del; //삭제여부
}
