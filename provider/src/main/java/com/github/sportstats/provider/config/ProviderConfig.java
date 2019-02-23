package com.github.sportstats.provider.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.github.sportstats.provider.repository")
@EntityScan("com.github.sportstats.provider.model")
@PropertySource("classpath:jpa.properties")
public class ProviderConfig {}
