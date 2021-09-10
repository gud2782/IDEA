package com.likeadog.idea.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Register_Vaccine {

    @Id @GeneratedValue
    private Long registerVaccineIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "registerIdx")
    private Register register;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vaccineIdx")
    private Vaccine vaccine;


}

