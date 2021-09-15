package com.likeadog.idea.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VaccineRepository {

    @PersistenceContext
    EntityManager em;
}
