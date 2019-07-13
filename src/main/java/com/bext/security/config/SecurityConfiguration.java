package com.bext.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("userpass").roles("USER").build());
        manager.createUser(users.username("admin").password("adminpass").roles("USER", "ADMIN").build());
        return manager;
    }
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}userpass").roles("USER").and()
                .withUser("admin").password("{nooop}adminpass").roles("ADMIN");
    }
    */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                //.antMatchers("/resource/**", "/login", "/contacto").permitAll()
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest()
                .fullyAuthenticated()
                //.anyRequest()
                //.permitAll()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
