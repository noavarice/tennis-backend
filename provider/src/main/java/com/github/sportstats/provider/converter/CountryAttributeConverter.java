package com.github.sportstats.provider.converter;

import com.github.sportstats.commons.enumeration.Country;
import javax.persistence.AttributeConverter;

/**
 * {@link AttributeConverter} for {@link Country} enum.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class CountryAttributeConverter extends AbstraceEnumConverter<Country> {

  @Override
  public Country convertToEntityAttribute(Integer dbData) {
    return Country
        .of(dbData)
        .orElseThrow(() -> new IllegalArgumentException("Unknown country ID value: " + dbData));
  }
}
