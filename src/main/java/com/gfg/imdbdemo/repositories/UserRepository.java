package com.gfg.imdbdemo.repositories;

import com.gfg.imdbdemo.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {
    MyUser findByUsername(String username);
}
