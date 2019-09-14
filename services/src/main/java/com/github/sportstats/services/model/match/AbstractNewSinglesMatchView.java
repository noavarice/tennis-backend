package com.github.sportstats.services.model.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.sportstats.services.validation.Errors;
import com.github.sportstats.services.validation.PropertyPath;
import com.github.sportstats.services.validation.group.BuiltIn;
import java.time.Instant;
import javax.validation.constraints.NotNull;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

/**
 * Base view for match classes.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Value.Immutable
@Value.Style(typeImmutable = "NewSinglesMatchView")
@JsonDeserialize(builder = NewSinglesMatchView.Builder.class)
public interface AbstractNewSinglesMatchView {

  @NotNull(
      message = PropertyPath.Match.STARTS_AT + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Nullable
  Instant getStartsAt();

  @NotNull(
      message = PropertyPath.Match.FIRST_PLAYER + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Nullable
  Integer getFirstPlayerId();

  @NotNull(
      message = PropertyPath.Match.SECOND_PLAYER + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Nullable
  Integer getSecondPlayerId();
}
