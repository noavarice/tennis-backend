package com.github.sportstats.provider.converter;

import com.github.sportstats.commons.enumeration.Country;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * {@link AttributeConverter} for {@link Country} enum.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Converter(autoApply = true)
public class CountryAttributeConverter implements AttributeConverter<Country, Integer> {

  @Override
  public Integer convertToDatabaseColumn(final Country attribute) {
    Objects.requireNonNull(attribute, "Country cannot be null");
    return attribute.getId();
  }

  @Override
  public Country convertToEntityAttribute(final Integer dbData) {
    Objects.requireNonNull(dbData, "Country cannot be null");
    return Country
        .of(dbData)
        .orElseThrow(() -> new IllegalArgumentException("Unknown country ID value: " + dbData));
  }
}
