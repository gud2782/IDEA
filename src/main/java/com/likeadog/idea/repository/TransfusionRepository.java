package com.likeadog.idea.repository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TransfusionRepository {

    private final EntityManager em;
}
