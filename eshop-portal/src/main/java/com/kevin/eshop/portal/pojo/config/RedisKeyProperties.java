package com.kevin.eshop.portal.pojo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisKeyProperties {
    private String database;
    private Key key;
    private Expire expire;
}
