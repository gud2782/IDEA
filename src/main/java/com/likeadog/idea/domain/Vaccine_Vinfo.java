package com.likeadog.idea.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Vaccine_Vinfo {

    @Id @GeneratedValue
    private Long vaccineVinfoIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vaccineIdx")
    private Vaccine vaccine;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vInfoIdx")
    private Vinfo vinfo;
}
