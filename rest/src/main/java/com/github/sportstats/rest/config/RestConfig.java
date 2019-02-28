package com.github.sportstats.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "com.github.sportstats.rest.controller",
    "com.github.sportstats.rest.exception.handler.advice",
    "com.github.sportstats.rest.jackson.serialization",
    "com.github.sportstats.services.config",
    "com.github.sportstats.commons.config",
})
public class RestConfig {}
