package com.gfg.imdbdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    /**
     * Download link Redis Insight :https://redis.com/redis-enterprise/redis-insight/?_ga=2.34915937.152882318.1656074957-1369941130.1655624378#insight-form
     * Try online console : https://try.redis.io/
     * Redis command list : https://redis.io/commands/
     *
     * <----Must read----->
     * Redis Data types: https://redis.io/docs/manual/data-types/
     *
     * Redis Eviction policies :https://redis.io/docs/manual/eviction/
     *
     * */

    /**There are 2 default driver for redis.
     * 1. Lettuce ( default)
     * 2. Jedis
     *
     * */

    /**
     * We create the 2 beans for Redis, first LettuceConnectionFactory and RedisTemplate.
     * Any NoSql database can be access by Template itself. considering the Redis as noSql database
     * as it stores the key value pair and it persist the data.
     * */


    @Bean
    public LettuceConnectionFactory getLettuceConnection(){

        RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration("redis-13358.c89.us-east-1-3.ec2.cloud.redislabs.com",13358);
        // It should be coming from properties file and should stored in encrypted way in properites.
        // ADD UR REDIS KEY HERE
        redisStandaloneConfiguration.setPassword("");
        return new LettuceConnectionFactory(redisStandaloneConfiguration);

    }

    /**
     * Redis stores key-value data.
     * where key is always a string and object can be anything.
     * it is similar to Map<String,Object> in java
     */


    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(LettuceConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
