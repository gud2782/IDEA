package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Qrcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrcodeRepository extends JpaRepository<Qrcode, Long> {
}
