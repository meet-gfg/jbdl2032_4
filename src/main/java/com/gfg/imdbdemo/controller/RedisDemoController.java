package com.gfg.imdbdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.imdbdemo.domain.Movie;
import com.gfg.imdbdemo.service.CommonUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisDemoController {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    CommonUtilService commonUtilService;

    /**
     * We us OpsForXXXX for any time of the redis operations
     * ex for String OpsForValue and for List OpsForList
     * */

    @GetMapping("/get")
    public Object getValue(@RequestParam String key){
        return  redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/add")
    public Object setValue(@RequestParam String key,@RequestParam Object value){
        redisTemplate.opsForValue().set(key,value);
        return value;
    }

    @PostMapping("/add/movie")
    public Object setMovie(@RequestBody Movie movie){
        ObjectMapper mapper=new ObjectMapper();
        Map<String,Object> movieMap=mapper.convertValue(movie,HashMap.class);
        redisTemplate.opsForHash().putAll(commonUtilService.getMovieKey(movie),movieMap);
        return movie;
    }

    /***
     * Sample Redis operation
     *
     * 	    String key="LIST::MOVIE::ACTION";
     * 		Movie movie1= Movie.builder().movieId(1L).genre(Genre.ACTION).title("MIB").build();
     * 		Movie movie2= Movie.builder().movieId(2L).genre(Genre.ACTION).title("SpiderMan").build();
     * 		Movie movie3= Movie.builder().movieId(3L).genre(Genre.ACTION).title("GOT").build();
     * 		redisTemplate.opsForList().leftPush(key,movie1);
     * 		redisTemplate.opsForList().rightPush(key,movie2);
     * 		redisTemplate.opsForList().leftPush(key,movie3);
     *
     * 		System.out.println(redisTemplate.opsForList().leftPop(key));
     * 		System.out.println(redisTemplate.opsForList().rightPop(key));
     *
     */


}
