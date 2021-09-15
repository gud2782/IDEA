package com.likeadog.idea.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DonationRepository {

    @PersistenceContext
    EntityManager em;

}
