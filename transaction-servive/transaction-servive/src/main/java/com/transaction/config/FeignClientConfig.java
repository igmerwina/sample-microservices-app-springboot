package com.transaction.config;

import com.transaction.client.CustomDecoder;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String pass;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, pass);
    }
    @Bean
    public CustomDecoder customDecoder() {
        return new CustomDecoder();
    }
}