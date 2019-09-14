package com.github.sportstats.entity.converter;

import com.github.sportstats.commons.enumeration.MatchStatus;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * {@link AttributeConverter} implementation for {@link MatchStatus}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Converter(autoApply = true)
public class MatchStatusAttributeConverter implements AttributeConverter<MatchStatus, Integer> {

  @Override
  public Integer convertToDatabaseColumn(final MatchStatus attribute) {
    Objects.requireNonNull(attribute, "Match status cannot be null");
    return attribute.getId();
  }

  @Override
  public MatchStatus convertToEntityAttribute(final Integer dbData) {
    Objects.requireNonNull(dbData, "Match status cannot be null");
    return MatchStatus
        .of(dbData)
        .orElseThrow(() -> new IllegalArgumentException("Unknown match status ID=" + dbData));
  }
}
