package com.kemi.actable.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/06/02  15:25
 */
@RestController
@RequestMapping
public class RedisAnnController {
    /**
    * @explain 存入或读取缓存
    * @param name
    * @param pnumber
    * @return java.lang.String
    * @author DUT-SUN
    * @date   2023/6/2
    */
    @RequestMapping("/ann-get")
    @Cacheable(value = "spring.cache",key = "#name+'-'+#pnumber")
    public String get(String name,String pnumber){
        if(!StringUtils.hasLength(name)|| !StringUtils.hasLength(pnumber)){
            return null;
        }
        return "name="+name+"|pnumber="+pnumber;
    }
    /**
    * @explain 缓存删除
    * @param name
    * @param pnumber
    * @return void   N
    * @author DUT-SUN
    * @date   2023/6/2
    */
    @RequestMapping("/del")
    @CacheEvict(value = "spring.cache",key = "#name+'-'+#pnumber")
    public void del(String name,String pnumber){
        System.out.println("执行了缓存删除！");
    }
    @RequestMapping("/put")
    @CachePut(value = "spring.cache",key = "#name+'-'+#pnumber")
    public String put(String name,String pnumber){
        if(!StringUtils.hasLength(name)|| !StringUtils.hasLength(pnumber)){
            return null;
        }
        System.out.println("put成功!!!");
        return "["+"name="+name +"<-> pnumber="+pnumber+"]";
    }
}
