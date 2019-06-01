package com.github.sportstats.rest.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

/**
 * Base serializer for {@link Enum} classes.
 *
 * @author noavarice
 * @since 0.0.1
 */
abstract class AbstractEnumSerializer<T extends Enum<T>> extends StdSerializer<T> {

  protected AbstractEnumSerializer(final Class<T> t) {
    super(t);
  }

  @Override
  public void serialize(final T value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeString(value.name());
  }
}
