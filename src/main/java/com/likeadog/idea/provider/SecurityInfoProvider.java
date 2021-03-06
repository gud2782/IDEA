package com.likeadog.idea.provider;

import com.likeadog.idea.domain.UserEntity;
import com.likeadog.idea.service.UserService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Slf4j
@NoArgsConstructor
public class SecurityInfoProvider {


    @Autowired
    static UserService userService;

    public static String getCurrentMemberId() {
        Authentication authentication = getCurrentUserAuthentication();
        return authentication.getName();
    }

    public static UserEntity getUserEntity(){
        String userId = getCurrentMemberId();
        return userService.findByUserID(userId);
    }

    public static String  getCurrentUserType() {
        Authentication authentication = getCurrentUserAuthentication();
        return (authentication.getAuthorities().toArray()[0].toString().substring(5));
    }


    // SecurityContext 에 유저 정보가 저장되는 시점
    private static Authentication getCurrentUserAuthentication() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw  new RuntimeException("Security Context does not contain authentication information.");
        }
        return authentication;
    }

}
