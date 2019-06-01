package com.github.sportstats.rest.jackson.serialize;

import com.github.sportstats.commons.enumeration.Country;
import org.springframework.stereotype.Component;

/**
 * Serializer for {@link Country}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Component
public class CountrySerializer extends AbstractEnumSerializer<Country> {

  protected CountrySerializer() {
    super(Country.class);
  }
}
