package com.likeadog.idea.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor //아무런 파라미터가 없는 기본 생성자를 생성해줌, jpa에서는 프록시 생성을 위해 기본생성자를 필요로 하기 때문에 부여
@Entity
@Getter
@Setter
@Table(name="user")
public class UserEntity extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue
    private Long userIdx;

    @Column(nullable=false)
    private String userId; //견주ID
    private String pw; //비밀번호
    private String name; //이름
    private String address; //주소
    private String detailAddress; //상세주소
    private String phone; //핸드폰번호


    private String role; //역할 부여


    @OneToMany(mappedBy = "user")
    private List<Register> registers = new ArrayList<>();


    @Builder //생성자에 Builder를 부여하면 생성자에 필요한 파라미터들을 포함하는 빌더를 자동으로 생성해줌
    public UserEntity(Long userIdx, String userId, String pw, String name , String address, String detailAddress, String phone, String role) {
        this.userIdx = userIdx;
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for(String role : role.split(",")){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}