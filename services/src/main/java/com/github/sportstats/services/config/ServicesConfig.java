package com.github.sportstats.services.config;

import com.github.sportstats.services.jackson.deserialize.InstantDeserializer;
import com.github.sportstats.services.jackson.deserialize.LocalDateDeserializer;
import com.github.sportstats.services.jackson.deserialize.TrimmingStringDeserializer;
import com.github.sportstats.services.jackson.serialize.InstantSerializer;
import com.github.sportstats.services.jackson.serialize.LocalDateSerializer;
import java.time.Instant;
import java.time.LocalDate;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

/**
 * Main {@link Configuration configuration} class for services module.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Configuration
@ComponentScan({
  "com.github.sportstats.provider.config",
  "com.github.sportstats.mapper.impl",
  "com.github.sportstats.services.service.impl",
  "com.github.sportstats.services.validation",
})
public class ServicesConfig {

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
        builder.deserializerByType(Instant.class, new InstantDeserializer());
        builder.serializerByType(Instant.class, new InstantSerializer());
      }

      return bean;
    }
  }
}
