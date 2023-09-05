package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.Dto.AutheposnseDTO;
import com.CRM.Backend.entities.Dto.LoginDTO;
import com.CRM.Backend.entities.Dto.RegisterDTO;
import com.CRM.Backend.entities.Dto.UserRoleResponseDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Role;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator.*;
import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/api/auth")
    public  class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
            @PostMapping("login")
    public ResponseEntity<AutheposnseDTO> login(@RequestBody LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getMail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserMail = SecurityContextHolder.getContext().getAuthentication().getName();
        MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)                .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

        Long userId = loggedInUser.getId();
        System.out.println("Authentication: " + auth);
        AutheposnseDTO responseDTO = new AutheposnseDTO(token, userId);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        if (userRepository.existsByMail(registerDto.getMail())) {
            return new ResponseEntity<>("This email is taken!", HttpStatus.BAD_REQUEST);
        }

        MyUser user = new MyUser();
        user.setMail(registerDto.getMail());
        user.setName(registerDto.getName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        if (registerDto.getRole() == Role.admin) {
            return new ResponseEntity<>("Cannot assign admin role during registration!", HttpStatus.BAD_REQUEST);
        }

        user.setRole(registerDto.getRole());

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")

    @GetMapping("/user-role")
    public ResponseEntity<UserRoleResponseDTO> getUserRole() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String loggedInUserMail = auth.getName();
            MyUser loggedInUser = userRepository.findByMail(loggedInUserMail)
                    .orElseThrow(() -> new UsernameNotFoundException("Logged-in user not found"));

            String userRole = String.valueOf(loggedInUser.getRole()); // Assuming you have a 'role' field in your MyUser entity

            UserRoleResponseDTO responseDTO = new UserRoleResponseDTO(userRole);

            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
