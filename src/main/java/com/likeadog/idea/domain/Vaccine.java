package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Vaccine extends BaseEntity{
    @Id
    @GeneratedValue
    private Long vaccineIdx;

   @OneToMany(mappedBy = "vaccine")
   private List<Register_Vaccine> registerVaccines = new ArrayList<>();

    @OneToMany(mappedBy = "vaccine")
    private List<Vaccine_Vinfo> vaccineVinfos = new ArrayList<>();

    private String vNumber; //차수
    private LocalDate vDate; //접종일
    private LocalDate nDate; //다음 접종일


}
