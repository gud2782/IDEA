package com.likeadog.idea.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class QrcodeRepository  {

    private final EntityManager em;



}
