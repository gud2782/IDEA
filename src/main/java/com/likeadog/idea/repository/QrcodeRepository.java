package com.likeadog.idea.repository;

import com.likeadog.idea.domain.Qrcode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class QrcodeRepository  {

    private final EntityManager em;
}
