package com.kevin.eshop.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kevin.eshop")
public class EshopPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopPortalApplication.class, args);
    }

}
