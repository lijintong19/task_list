package com.tpcs.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决前后端的跨域问题
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 允许任何跨域的域名，*表示允许任何域名使用
                .allowedMethods("*")// 允许任何方法
                .allowedHeaders("*")
                .allowCredentials(true)// 带上cookie信息
                .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
    }

}
