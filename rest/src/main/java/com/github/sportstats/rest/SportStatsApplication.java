package com.github.sportstats.rest;

import com.github.sportstats.rest.config.BasePackageRef;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application entry point.
 *
 * @author noavarice
 * @since 0.0.1
 */
@SpringBootApplication(
    scanBasePackageClasses = BasePackageRef.class
)
public class SportStatsApplication {

  public static void main(final String[] args) {
    SpringApplication.run(SportStatsApplication.class);
  }
}
