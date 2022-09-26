package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
        String redisKey = "test:count";
        redisTemplate.opsForValue().set(redisKey,1);
        System.out.println(redisTemplate.opsForValue().get(redisKey));
        System.out.println(redisTemplate.opsForValue().get("userLikeKeytest"));
    }

    @Test
    public void testSet(){
        String redisKey2 = "userLikeKeytest";
        redisTemplate.opsForZSet().add(redisKey2,1,System.currentTimeMillis());
        System.out.println(redisTemplate.opsForZSet().range(redisKey2,0,-1));
    }


}
