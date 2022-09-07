package com.admin.campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties
@EnableAsync
public class CampaignAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampaignAdminServiceApplication.class, args);
    }
}
