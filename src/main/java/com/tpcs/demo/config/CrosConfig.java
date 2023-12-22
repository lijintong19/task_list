package com.tpcs.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 解决前后端的跨域问题
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOriginPatterns("*")
        .allowedMethods("GET","HEAD","POST","PUT","DELETE")
        .maxAge(3000)
        .allowedHeaders("*");
    }
    
}
