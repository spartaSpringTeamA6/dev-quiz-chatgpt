package org.example.devquizbatch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@EntityScan("org.example.devquizbatch.domain")
@EnableJpaRepositories("org.example.devquizbatch.domain")
public class BatchTestConfig {

}
