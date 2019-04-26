package com.atguigu.springcloud.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CusHandlerInterceptorAdapterConfig  extends WebMvcConfigurerAdapter {

 /*   @Bean
    public CusHandlerInterceptorAdapter aa(){
        return new CusHandlerInterceptorAdapter();
    }*/
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new CusHandlerInterceptorAdapter());
        interceptor.addPathPatterns("/**");
    }
}
