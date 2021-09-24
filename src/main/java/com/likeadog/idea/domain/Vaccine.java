package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
   private List<RegisterVaccine> registerVaccines = new ArrayList<>();

    @OneToMany(mappedBy = "vaccine")
    private List<VaccineVinfo> vaccineVinfos = new ArrayList<>();

    private String vNumber; //차수
    private String vDate; //접종일
    private String nDate; //다음 접종일


}
