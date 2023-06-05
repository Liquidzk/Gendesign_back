//package com.zty;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import javax.annotation.Resource;
//
//@SpringBootTest
//public class RedisTest {
//
//    @Resource
//    RedisTemplate redisTemplate;
//
//    @Test
//    public void testStrings(){
//        String redisKey = "test:count";
//
//        redisTemplate.opsForValue().set(redisKey,1);
//        System.out.println(redisTemplate.opsForValue().get(redisKey));;
////        System.out.println(redisTemplate.opsForValue().increment(redisKey));
////        System.out.println(redisTemplate.opsForValue().decrement(redisKey));
//    }
//
//
//}