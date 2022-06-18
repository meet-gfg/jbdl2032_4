package com.gfg.imdbdemo.service;

import com.gfg.imdbdemo.domain.MyUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserService implements UserDetailsService {

    Map<String,UserDetails> userMap=new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMap.getOrDefault(username, new MyUser());
    }


    public void addUser(MyUser user){
        this.userMap.put(user.getUsername(),user);
    }
}
