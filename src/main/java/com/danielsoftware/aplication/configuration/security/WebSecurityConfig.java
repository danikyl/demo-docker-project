package com.danielsoftware.aplication.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/subscription/update").permitAll()
                .antMatchers(HttpMethod.GET, "/subscription/all").permitAll()
                .antMatchers(HttpMethod.GET, "/eventHistory/all").permitAll()
                .anyRequest().authenticated().and()
                .csrf().disable();
    }
}
