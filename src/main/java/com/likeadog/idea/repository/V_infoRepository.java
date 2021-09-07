package com.likeadog.idea.repository;

import com.likeadog.idea.domain.V_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface V_infoRepository extends JpaRepository<V_info, Long> {
}
