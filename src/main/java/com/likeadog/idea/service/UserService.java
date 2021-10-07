package com.likeadog.idea.service;


import com.likeadog.idea.config.UserContext;
import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.dto.UserDto;
import com.likeadog.idea.enumCollection.DeleteStatus;
import com.likeadog.idea.provider.SecurityInfoProvider;
import com.likeadog.idea.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Delete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long createUser(UserDto form) throws Exception {
        if (checkDuplicateId(form.getUserId())==0) {
            //비밀번호 암호화
            form.setPw(passwordEncoder.encode(form.getPw()));
            UserEntity userEntity = form.toEntity();

            userEntity.setDel(DeleteStatus.NO);

            userRepository.save(userEntity);
            return userEntity.getUserIdx();
        } else{
            throw new Exception("중복사용자");
        }


    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        //UserEntity userEntity = userRepository.findByUserId(userId);
        //리포지토리에 추가한 메소드로 대체 -> 탈퇴한 회원들 제외하고 db 검색
        UserEntity userEntity = userRepository.findByUserIdWhereDelIsNo(userId);

        if (userEntity == null) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(userEntity.getRole()));

        UserContext userContext = new UserContext(userEntity, roles);
        return userContext;
    }



    //중복 ID 체크
    public int checkDuplicateId(String userId){
        return userRepository.countByUserId(userId);
    }

    public UserEntity findByUserID(String userId){
        return userRepository.findByUserId(userId);
    }


    //회원탈퇴
    @Transactional
    public void delUser() {
        String userId = SecurityInfoProvider.getCurrentMemberId();
        UserEntity userEntity = findByUserID(userId);

        userEntity.setDel(DeleteStatus.YES);
        userRepository.save(userEntity);

    }
}
