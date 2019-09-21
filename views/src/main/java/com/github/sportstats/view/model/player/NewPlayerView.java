package com.github.sportstats.view.model.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.sportstats.view.validation.Errors;
import com.github.sportstats.view.validation.PropertyPath;
import com.github.sportstats.view.validation.group.BuiltIn;
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
