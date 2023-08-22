package com.CRM.Backend.security;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Role;
import com.CRM.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class    CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository  ;
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        MyUser user = userRepository.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Mail not found"));

        return new User(user.getMail(), user.getPassword(), mapRolesToAuthorities(Collections.singletonList(user.getRole())));
    }




    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }
}