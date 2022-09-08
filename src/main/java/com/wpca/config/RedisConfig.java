package com.wpca.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author XieQijiang
 * @Pcakage com.markhub.config.RedisConfig
 * @Date 2022年07月15日 07:08
 * @Description    Redis配置类  连接redis
 */
@Configuration
public class RedisConfig {
    @Bean
    RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){

    //对redis模板配置
    RedisTemplate redisTemplate =new RedisTemplate();
    //设置连接池
    redisTemplate.setConnectionFactory(redisConnectionFactory);


    //普通存放可序列化方式
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =new Jackson2JsonRedisSerializer(Object.class);
    jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());


    //hash可序列化方式
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

    return redisTemplate;
}
}
