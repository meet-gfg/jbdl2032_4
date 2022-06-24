package com.gfg.imdbdemo.service.request;

import com.gfg.imdbdemo.domain.MyUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String password;
    private Boolean isAdmin;


    public MyUser toMyUser(){
        return MyUser.builder()
                .username(this.userName)
                .password(this.password)
                .authorities(getIsAdmin()?"admin":"user")
                .build();
    }
}
