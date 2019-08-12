package com.github.sportstats.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main {@link Configuration configuration} class for services module.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Configuration
@ComponentScan({
  "com.github.sportstats.provider.config",
  "com.github.sportstats.services.service.impl",
  "com.github.sportstats.services.mapper.impl",
  "com.github.sportstats.services.validation",
})
public class ServicesConfig {}
