package com.github.sportstats.services.jackson.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * {@link StdDeserializer} implementation to always trim string properties.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class TrimmingStringDeserializer extends StdDeserializer<String> {

  public TrimmingStringDeserializer() {
    super(String.class);
  }

  @Override
  public String deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException{
    return p.getValueAsString().trim();
  }
}
