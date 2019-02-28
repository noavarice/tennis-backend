package com.github.sportstats.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main {@link Configuration confiuration} component for commons module.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Configuration
@ComponentScan("com.github.sportstats.commons.mapper")
public class CommonsConfig {}
