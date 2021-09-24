package com.likeadog.idea.controller.form;

import com.likeadog.idea.domain.RegisterVaccine;
import com.likeadog.idea.domain.VaccineVinfo;
import com.likeadog.idea.enumCollection.DeleteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class VaccineForm {

    private Long vaccineIdx;
    private String vNumber; //차수
    private String vDate; //접종일
    private String nDate; //다음 접종일

    private List<RegisterVaccine> registerVaccines;
    private List<VaccineVinfo> vaccineVinfos;

    private String creater; //생성자
    private String modifier; //수정자
    private LocalDateTime cDate; //생성날짜
    private LocalDateTime mDate; //수정날짜

    @Enumerated(EnumType.STRING)
    private DeleteEnum del; //삭제여부

}
