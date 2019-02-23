package com.github.sportstats.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
  "com.github.sportstats.provider.config",
  "com.github.sportstats.services.service.impl",
  "com.github.sportstats.services.mapper.impl",
})
public class ServicesConfig {}
