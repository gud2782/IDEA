package com.likeadog.idea.config;

import com.likeadog.idea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    // 검증을 위한 구현
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String)authentication.getCredentials();

        UserContext userContext = (UserContext) usersService.loadUserByUsername(username);


        System.out.println(password +", " +userContext.getUserEntity().getPw());
        // password 일치하지 않으면!
        if(!passwordEncoder.matches(password,userContext.getUserEntity().getPw())){
            throw new BadCredentialsException("비밀번호가 다릅니다");
        }

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(
                userContext.getUserEntity(),
                null,
                userContext.getAuthorities());

        return authenticationToken;
    }

    // 토큰 타입과 일치할 때 인증
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}