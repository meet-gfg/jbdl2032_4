package com.gfg.imdbdemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Till Spring Security 4
 *  to provide the configuration one needs to extends WebSecurityConfigurerAdapter.
 *  and override the configuration of the HttpSecurity , PasswordEncoder and UserDetailsService , AuthorizationManager
 *
 *  After Spring security 5
 *
 *  To provide the configuration one needs to create a bean for FilterChain, PasswordEncoder, UserDetailsService and AuthorityProvider
 *
 * */

/***
 * Types of authentication
 *
 *  1. username&Password
 *  2. LdapAuthentication
 *  3.JdbcAuthentication
 *  check Authentication class for different types of authentication
 * */

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder getMyPasswordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }

}


/*
For all the steps here, the default definition already exists in Spring Security

* 1. get the credentials from the user  ///Spring --> AuthenticationManager (authenticate)
* 2. get the creds from the DB /// Spring --> UserDetailsService     /// already done--> sign up first, would username and password  which we store for firstime in DB.
* 3. compare the creds  /// Spring --> passwordEncoder ( BcryptEncoder NoOpPasswordEncoder)
* 4. if Matches then return true or session ID // FilterChain ( basic filtration -> authentication , second -> authorization ++ custom filters)
* 5. else return the invalid creds //FilterChain
*
*
* */
