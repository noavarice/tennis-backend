package com.github.sportstats.rest.jackson.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@link StdDeserializer} implementation for {@link LocalDate dates} from established format.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

  public LocalDateDeserializer() {
    super(LocalDate.class);
  }

  @Override
  public LocalDate deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
    return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ISO_DATE);
  }
}
