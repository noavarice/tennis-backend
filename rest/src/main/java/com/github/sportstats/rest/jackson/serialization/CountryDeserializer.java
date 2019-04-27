package com.github.sportstats.rest.jackson.serialization;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.sportstats.commons.enumeration.Country;
import java.io.IOException;
import org.springframework.stereotype.Component;

/**
 * Custom deserializer for {@link Country} enumeration.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Component
public class CountryDeserializer extends StdDeserializer<Country> {

  public CountryDeserializer() {
    super(Country.class);
  }

  @Override
  public Country deserialize(JsonParser p, DeserializationContext context) throws IOException {
    return Country.valueOf(p.getValueAsString());
  }
}
