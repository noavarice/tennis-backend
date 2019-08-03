package com.github.sportstats.rest.view.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.sportstats.rest.validation.Errors;
import com.github.sportstats.rest.validation.PropertyPath;
import com.github.sportstats.rest.validation.group.BuiltIn;
import javax.validation.constraints.NotNull;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

/**
 * Input view containing information about adding player.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Value.Immutable
@JsonDeserialize(builder = ImmutableNewPlayerView.Builder.class)
public interface NewPlayerView extends AbstractPlayerView {

  @NotNull(
      message = PropertyPath.Player.MALE + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Nullable
  Boolean getMale();
}
