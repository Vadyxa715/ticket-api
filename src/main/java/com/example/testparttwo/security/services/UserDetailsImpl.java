package com.example.testparttwo.security.services;

import com.example.testparttwo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@EqualsAndHashCode
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String login;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String login, String password,
                           Collection<? extends GrantedAuthority> authorities) {

        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        //List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(roleRepo.findById(user.getRoleId()).toString()));
        //List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().getRole().name()));
       // List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        //List<GrantedAuthority> authorities = List.of((new SimpleGrantedAuthority(user.getRole().getRole().name())));


//        List<GrantedAuthority> authorities = new ArrayList<>();
//            authorities.set(0,new SimpleGrantedAuthority("ROLE_USER"));
//            authorities.set(1,new SimpleGrantedAuthority("ROLE_ADMIN"));
//            authorities.set(2,new SimpleGrantedAuthority("ROLE_MODERATOR"));


        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public String getUsername() {
        return login;
    }
}
