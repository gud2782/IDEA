package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Donation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DonationRepository {
    private final EntityManager em;

}
