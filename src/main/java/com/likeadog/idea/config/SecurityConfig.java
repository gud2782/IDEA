package com.likeadog.idea.config;


import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@AllArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 활성화 어노테이션
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



   // private final UserService userService;


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(); //시큐리티에서 제공하는 비밀번호 암호화 객체
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }




    @Override
    public void configure(WebSecurity web) throws Exception { // 인증을 무시할 경로
        //  web.ignoring().mvcMatchers("/**");
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());    // 정적자원 로그인 없이
        web.ignoring().antMatchers("/img/**","/bootstrap/**","/css/**","/inc/**","/js/**","/less/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home", "/user/register","/user/main").permitAll() // 누구나 접근 허용
               // .antMatchers("/user").hasRole("USER") // USER만 접근 가능
               // .antMatchers("/manager").hasRole("MANAGER") // MANAGER만 접근 가능
               // .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능


                .and() //로그인 관련 설정

                .formLogin()//인가,인증에 문제시 로그인 화면
                .loginPage("/user/login") //사용자 정의 로그인 페이지
                .loginProcessingUrl("/user/loginProcess") //전송버튼 클릭시 전송되는 url
                .failureUrl("/user/loginError") //로그인 실패시 이동
                .usernameParameter("userId")
                .passwordParameter("pw")
                .defaultSuccessUrl("/user/loginSuccess",true) //로그인 성공 후 이동 페이지
                .permitAll()


                .and() // 로그아웃 관련 설정

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .addLogoutHandler(new TaskImplementingLogoutHandler())
                .permitAll()
                .logoutSuccessUrl("/user/logout")  // 로그아웃 성공시 리다이렉트 주소

                .and()  // 403 예외처리 핸들링

                .exceptionHandling()
                .accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 로그인 필요 정보
        auth.authenticationProvider(authenticationProvider());

    }

}
