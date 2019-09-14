package com.github.sportstats.services.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.Instant;

/**
 * Common JSON serializer for {@link Instant} values.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class InstantSerializer extends StdSerializer<Instant> {

  public InstantSerializer() {
    super(Instant.class);
  }

  @Override
  public void serialize(final Instant value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeString(value.toString());
  }
}
