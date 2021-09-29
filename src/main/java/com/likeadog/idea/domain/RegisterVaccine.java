package com.likeadog.idea.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@SequenceGenerator(name = "RegisterVaccine_SEQ_Generator" , initialValue = 1, allocationSize = 1)
public class RegisterVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegisterVaccine_SEQ_Generator")
    private Long registerVaccineIdx;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "registerIdx")
    private Register register;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vaccineIdx")
    private Vaccine vaccine;



}

