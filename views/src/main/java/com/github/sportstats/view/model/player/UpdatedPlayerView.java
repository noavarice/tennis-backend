package com.github.sportstats.view.model.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.OptionalInt;
import org.immutables.value.Value;

/**
 * Represents request body for updated information about player.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Value.Immutable
@JsonDeserialize(builder = ImmutableUpdatedPlayerView.Builder.class)
public interface UpdatedPlayerView extends AbstractPlayerView {

  @JsonIgnore
  OptionalInt getId();
}
