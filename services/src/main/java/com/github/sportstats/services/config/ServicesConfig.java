package com.github.sportstats.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
  "com.github.sportstats.services.service",
  "com.github.sportstats.provider.config",
})
public class ServicesConfig {}
