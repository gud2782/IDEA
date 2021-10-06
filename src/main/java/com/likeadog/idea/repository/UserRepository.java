package com.likeadog.idea.repository;


import com.likeadog.idea.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(String userId); //crud를 위한 메서드가 자동 생성

    int countByUserId(String userId);



}






