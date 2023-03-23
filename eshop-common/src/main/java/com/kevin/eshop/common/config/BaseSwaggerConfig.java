package com.kevin.eshop.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class BaseSwaggerConfig {
    @Bean
    public OpenAPI config() {
        return new OpenAPI().info(apiInfo());
    }

    @Bean
    @Profile("!prod")   // enable in non-production
    public GroupedOpenApi version1Api() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    // api document info
    private Info apiInfo() {
        return new Info().title("EShop API")
                .description("API document for EShop")
                .version("v1.0")
                .license(new License().name("Apache 2.0"));
    }
}
