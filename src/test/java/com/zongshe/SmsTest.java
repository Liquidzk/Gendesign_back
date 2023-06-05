package com.zongshe;

import com.zongshe.util.SendSMSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SmsTest {

    @Autowired
    SendSMSUtil sendSMSUtil;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void testSendSms(){
        String phoneNumber = "15335737502";
        String code = "123456";
        redisTemplate.opsForValue().set("sms:code:"+ phoneNumber,code,10, TimeUnit.MINUTES);
        sendSMSUtil.sendSms(phoneNumber,code);
    }
}
