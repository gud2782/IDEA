package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Vinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface V_infoRepository extends JpaRepository<Vinfo, Long> {
}
