package com.github.sportstats.commons.mapper;

import com.github.sportstats.commons.enumeration.Country;
import org.springframework.stereotype.Component;

/**
 * {@link IEnumMapper} implementation for {@link Country} enum.
 *
 * @author noavarice
 * @since 0.0.1
 * @see IEnumMapper
 */
@Component
public class CountryMapper implements IEnumMapper<Country> {

  @Override
  public Country toEnum(Integer id) {
    return Country.of(id).orElse(null);
  }
}
