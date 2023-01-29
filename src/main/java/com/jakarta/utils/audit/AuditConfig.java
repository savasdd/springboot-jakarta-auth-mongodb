package com.jakarta.utils.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableMongoAuditing(auditorAwareRef = "aware")
public class AuditConfig {

    @Bean
    public AuditorAware<String> aware() {
        return new AuditorAwareImpl();
    }

}