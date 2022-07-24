package com.miao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testString() {
        ValueOperations stringOper = redisTemplate.opsForValue();
        stringOper.set("name", "lky");


        System.out.println(stringOper.get("name"));
    }

    @Test
    public void testHash() {
        HashOperations hashOperations = redisTemplate.opsForHash();

        Map map = new HashMap();
        map.put("name", "lky");
        map.put("age", 23);
        hashOperations.put("hash1", "name", "lky");
        hashOperations.putAll("hash2", map);
    }
}
