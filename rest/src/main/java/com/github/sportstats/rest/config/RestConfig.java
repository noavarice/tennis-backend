package com.github.sportstats.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
  "com.github.sportstats.rest.controller",
  "com.github.sportstats.services.config"
})
public class RestConfig {}
