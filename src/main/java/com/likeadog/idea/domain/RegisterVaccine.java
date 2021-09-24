package com.likeadog.idea.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class RegisterVaccine {

    @Id @GeneratedValue
    private Long registerVaccineIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "registerIdx")
    private Register register;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vaccineIdx")
    private Vaccine vaccine;



}

