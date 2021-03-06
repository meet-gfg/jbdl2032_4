package com.gfg.imdbdemo;

import com.gfg.imdbdemo.domain.Genre;
import com.gfg.imdbdemo.domain.Movie;
import com.gfg.imdbdemo.domain.MyUser;
import com.gfg.imdbdemo.repositories.MovieRepository;
import com.gfg.imdbdemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class ImdbdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ImdbdemoApplication.class, args);
	}

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	MyUserService service;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Override
	public void run(String... args) throws Exception {
	}
}


/**
 *DDL-AUTO
 * {
 *       "name": "spring.jpa.hibernate.ddl-auto",
 *       "values": [
 *         {
 *           "value": "none",
 *           "description": "Disable DDL handling."
 *         },
 *         {
 *           "value": "validate",
 *           "description": "Validate the schema, make no changes to the database."
 *         },
 *         {
 *           "value": "update",
 *           "description": "Update the schema if necessary."
 *         },
 *         {
 *           "value": "create",
 *           "description": "Create the schema and destroy previous data."
 *         },
 *         {
 *           "value": "create-drop",
 *           "description": "Create and then destroy the schema at the end of the session."
 *         }
 *       ]
 *     }
 * */





























