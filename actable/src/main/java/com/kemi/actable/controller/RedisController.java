package com.kemi.actable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/06/02  14:28
 */
@RestController
public class RedisController {
    //引入redis本身
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/set")
    public String setRedis(){
       stringRedisTemplate.opsForValue().set("username","张三");
       return "redis 存储成功！";
   }
   @RequestMapping("/get")
    public String getRedis(){
        String name=stringRedisTemplate.opsForValue().get("username");
        return name;
   }
}
