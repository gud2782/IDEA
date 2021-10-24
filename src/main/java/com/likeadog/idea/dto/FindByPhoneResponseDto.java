package com.likeadog.idea.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FindByPhoneResponseDto {

    String aniId;
    String aniName;
    String weight;
    String kind;
    String color;


}