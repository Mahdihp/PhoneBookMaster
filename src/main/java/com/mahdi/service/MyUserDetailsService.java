package com.mahdi.service;

import com.mahdi.model.User;
import com.mahdi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println(user);
        return new MyUserPrincipal(user);
//        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
//        builder = org.springframework.security.core.userdetails.User.withUsername(username);
//        builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
//        builder.roles(user.getRole().toString());
//        return builder.build();
    }
}