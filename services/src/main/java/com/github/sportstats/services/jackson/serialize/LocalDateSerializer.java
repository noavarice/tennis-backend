package com.github.sportstats.services.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@link StdSerializer} extension to format output dates as ISO dates.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

  public LocalDateSerializer() {
    super(LocalDate.class);
  }

  @Override
  public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeString(value.format(DateTimeFormatter.ISO_DATE));
  }
}
