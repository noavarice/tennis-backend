package com.github.sportstats.services.jackson.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.Instant;

/**
 * Commom JSON deserializer for {@link Instant} values.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class InstantDeserializer extends StdDeserializer<Instant> {

  public InstantDeserializer() {
    super(Instant.class);
  }

  @Override
  public Instant deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
    return Instant.parse(p.getValueAsString());
  }
}
