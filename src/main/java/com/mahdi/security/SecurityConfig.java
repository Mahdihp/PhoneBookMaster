package com.mahdi.security;

import com.mahdi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.persistence.Basic;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private static final String DEFULT_PASSWORD = new BCryptPasswordEncoder()
            .encode("110");


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder aut) throws Exception {
        aut.jdbcAuthentication().withUser("ali")
                .password(DEFULT_PASSWORD).roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated();

    }
}
