package com.kemi.actable.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/21  17:41
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterCepter())

               .addPathPatterns("/**")
               .excludePathPatterns("/css/**")
               .excludePathPatterns("/editor.md/**")
               .excludePathPatterns("/image/**")
               .excludePathPatterns("/js/**")
               .excludePathPatterns("/set")
               .excludePathPatterns("/login.html")
               .excludePathPatterns("/reg.html")
               .excludePathPatterns("/art/detail")
               .excludePathPatterns("/blog_list.html")
               .excludePathPatterns("/blog_context.html")
               .excludePathPatterns("/user/login")
               .excludePathPatterns("/user/reg")
               .excludePathPatterns("/user/getuserbyid")
               .excludePathPatterns("/art/incr-rcount")
               .excludePathPatterns("/art/fetlistbypage")
               .excludePathPatterns("/invoice/**")
               .excludePathPatterns("/initerary/**")
              ;


    }
}
