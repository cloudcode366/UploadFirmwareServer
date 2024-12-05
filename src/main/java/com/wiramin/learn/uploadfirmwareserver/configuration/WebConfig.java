package com.wiramin.learn.uploadfirmwareserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/v1/storage/*")
//                .allowedOriginPatterns("*") // Cho phép mọi nguồn (nếu bạn không sử dụng allowCredentials)
//                .allowedMethods("POST", "GET", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(false); // Chỉ cần đảm bảo không sử dụng "*" ở allowedOrigins
        registry.addMapping("/**")
                .allowedMethods("*");
    }
}
