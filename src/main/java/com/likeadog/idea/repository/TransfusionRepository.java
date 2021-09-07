package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Transfusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfusionRepository extends JpaRepository<Transfusion, Long> {
}
