package com.bext.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                //.antMatchers("/resource/**", "/login", "/contacto").permitAll()
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                //.anyRequest().authenticated()
                .anyRequest()
                .permitAll()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
