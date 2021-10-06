package com.likeadog.idea.config;

import com.likeadog.idea.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserContext extends User {

    private final UserEntity userEntity;

    public UserContext (UserEntity userEntity, Collection<? extends GrantedAuthority> authorities){
        super(userEntity.getUserId(), userEntity.getPw(), authorities);
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity(){

        return userEntity;
    }

}
