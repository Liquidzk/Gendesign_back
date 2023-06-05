package com.zongshe.web;

import com.zongshe.util.SendSMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class SmsSendController {

    @Autowired
    SendSMSUtil sendSMSUtil;
    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping(value = "/sendSms")
    public String sendCode(String phoneNumber){
        String redisCode = redisTemplate.opsForValue().get("sms:code:"+ phoneNumber);
        if(!StringUtils.isEmpty(redisCode)){
            long l = Long.parseLong(redisCode.split("_")[1]);
            if(System.currentTimeMillis() - l < 60000){
                //60秒内不能再发
                return "error";
            };
        }
        String code = UUID.randomUUID().toString().substring(0,5);
        System.out.println(phoneNumber);
        System.out.println(code);
        redisTemplate.opsForValue().set("sms:code:"+ phoneNumber,code,10, TimeUnit.MINUTES);
        sendSMSUtil.sendSms(phoneNumber,code);
        return "ok";
    }
}
