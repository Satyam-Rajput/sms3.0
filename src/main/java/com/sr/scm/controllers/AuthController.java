package com.sr.scm.controllers;

import com.sr.scm.dtos.UserDTO;
import com.sr.scm.entities.Users;
import com.sr.scm.repos.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));

        if (authentication.isAuthenticated()) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        Users user = Users.parseUserFromDTO(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setExpired(false);
        user.setLocked(false);
        user.setRoles(List.of("USER"));
        user = userRepository.saveAndFlush(user);
        return Users.parseDTOFromUser(user);
    }
}
