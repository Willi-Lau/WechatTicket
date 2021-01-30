package com.lwy.demo.config;


import com.lwy.demo.interceptor.CrossOrginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {



    @Bean
    public CrossOrginInterceptor crossOrginInterceptor(){
        return new CrossOrginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(crossOrginInterceptor()).addPathPatterns("/*");
    }
}
