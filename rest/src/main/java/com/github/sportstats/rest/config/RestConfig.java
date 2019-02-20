package com.github.sportstats.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
  "com.github.sportstats.rest",
  "com.github.sportstats.services"
})
public class RestConfig {

}
