package com.generation.javeat.controllers.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI();
    }

    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter(){
        return new ForwardedHeaderFilter();
    }
}