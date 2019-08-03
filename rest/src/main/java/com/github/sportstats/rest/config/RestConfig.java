package com.github.sportstats.rest.config;

import com.github.sportstats.rest.jackson.deserialize.LocalDateDeserializer;
import com.github.sportstats.rest.jackson.deserialize.TrimmingStringDeserializer;
import com.github.sportstats.rest.jackson.serialize.LocalDateSerializer;
import java.time.LocalDate;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * Main {@link Configuration configuration} class for REST module.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Configuration
@ComponentScan({
    "com.github.sportstats.rest.controller",
    "com.github.sportstats.rest.exception.handler.advice",
    "com.github.sportstats.rest.validation",
    "com.github.sportstats.services.config",
    "com.github.sportstats.commons.config",
    "com.github.sportstats.rest.mapper.impl",
})
public class RestConfig {

  /**
   * Customizes Jackson (de-)serialization.
   */
  @Component
  static class JacksonMapperPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) {
      if (bean instanceof Jackson2ObjectMapperBuilder) {
        final var builder = (Jackson2ObjectMapperBuilder)bean;
        builder.deserializerByType(String.class, new TrimmingStringDeserializer());
        builder.deserializerByType(LocalDate.class, new LocalDateDeserializer());
        builder.serializerByType(LocalDate.class, new LocalDateSerializer());
      }

      return bean;
    }
  }
}
