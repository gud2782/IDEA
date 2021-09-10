package com.likeadog.idea.service;

import com.likeadog.idea.domain.User;
import com.likeadog.idea.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    //회원가입
    @Transactional
    public Long join(User user) {

        validateDuplicateUser(user); //중복 회원 검증
        userRepository.save(user);
        return user.getUserIdx();

    }

    //중복 회원 검사
    private void validateDuplicateUser(User user) {
        List<User> findMembers =
                userRepository.findByUserId(user.getUserId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}