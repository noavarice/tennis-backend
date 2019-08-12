package com.github.sportstats.provider.converter;

import com.github.sportstats.provider.model.MatchEntity;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import javax.persistence.AttributeConverter;

/**
 * {@link AttributeConverter} implementation between {@link MatchEntity match} duration
 * in minutes and {@link Duration}.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class MatchDurationAttributeConverter implements AttributeConverter<Duration, Integer> {

  @Override
  public Integer convertToDatabaseColumn(final Duration attribute) {
    if (attribute == null) {
      return null;
    }

    return (int)attribute.toMinutes();
  }

  @Override
  public Duration convertToEntityAttribute(final Integer dbData) {
    if (dbData == null) {
      return null;
    }

    return Duration.of(dbData, ChronoUnit.MINUTES);
  }
}
