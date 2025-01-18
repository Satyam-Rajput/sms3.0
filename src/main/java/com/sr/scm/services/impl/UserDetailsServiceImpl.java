package com.sr.scm.services.impl;

import com.sr.scm.entities.Users;
import com.sr.scm.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder().username(user.getUsername()).password(user.getPassword()).accountExpired(user.getLocked())
                .authorities(user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())).
                disabled(user.getExpired()).build();
    }
}
