package com.likeadog.idea.repository;


import com.likeadog.idea.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(String userId); //crud를 위한 메서드가 자동 생성

    int countByUserId(String userId);


    // DeleteStatus No 인 회원들 중 userID 일치하는 회원 가져옴
    @Query("select u from UserEntity u where u.userId=:userId and u.del='NO'")
    UserEntity findByUserIdWhereDelIsNo(@Param("userId")String userId);



}






