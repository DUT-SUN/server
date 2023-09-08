package com.kemi.actable;

import com.kemi.actable.config.CanalClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@MapperScan(value = {"com.kemi.actable.mapper","com.gitee.sunchenbin.mybatis.actable.dao.*"})
@ComponentScan(value = {"com.kemi","com.gitee.sunchenbin.mybatis.actable.manager.*"})
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
@EnableCaching//开启全局注解缓存
public class ActableApplication {
    @Autowired
    private CanalClient canalClient;
    public static void main(String[] args) {
        SpringApplication.run(ActableApplication.class, args);
    }
//    @PostConstruct
//    public void init() {
//        Thread canalThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                canalClient.start();
//            }
//        });
//        canalThread.start();
//    }

}
