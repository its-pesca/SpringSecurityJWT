package com.khaoula.venteservice.JwtConfig;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class OpenFeignConfig {

    @Autowired
    public JwtTokenProvider jwtTokenProvider;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            List<String> roles = List.of(new String[]{"USER", "ADMIN"});
            String token = jwtTokenProvider.generateToken("admin", roles);
            requestTemplate.header("Authorization","Bearer "+token);
        };
    }
}
