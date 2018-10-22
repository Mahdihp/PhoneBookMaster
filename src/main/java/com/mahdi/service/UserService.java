package com.mahdi.service;


import com.mahdi.model.Role;
import com.mahdi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserService implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.mahdi.model.User userByUsername = userRepository.findUserByUsername(s);
        List<GrantedAuthority> authorities = buildUserForAuthentication(userByUsername.getRole());

        return buildUserForAuthentication(userByUsername, authorities);
    }

    private User buildUserForAuthentication(com.mahdi.model.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserForAuthentication(Role userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities

        setAuths.add(new SimpleGrantedAuthority(userRoles.getName()));

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
