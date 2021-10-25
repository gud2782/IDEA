package com.likeadog.idea.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Vaccine_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class Vaccine extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Vaccine_SEQ_Generator")
    private Long vaccineIdx;

   @OneToMany(mappedBy = "vaccine")
   private List<RegisterVaccine> registerVaccines = new ArrayList<>();

    @OneToMany(mappedBy = "vaccine")
    private List<VaccineVinfo> vaccineVinfos = new ArrayList<>();

    private String vNumber; //차수
    private String vDate; //접종일
    private String nDate; //다음 접종일
    private String hash;


}
