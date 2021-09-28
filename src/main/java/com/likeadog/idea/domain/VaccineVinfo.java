package com.likeadog.idea.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@SequenceGenerator(name = "VaccineVinfo_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class VaccineVinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VaccineVinfo_SEQ_Generator")
    private Long vaccineVinfoIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vaccineIdx")
    private Vaccine vaccine;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vInfoIdx")
    private Vinfo vinfo;
}
