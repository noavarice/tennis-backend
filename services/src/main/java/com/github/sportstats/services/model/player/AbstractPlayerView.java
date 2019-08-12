package com.github.sportstats.services.model.player;

import com.github.sportstats.commons.enumeration.Country;
import com.github.sportstats.services.validation.ConstraintConstants;
import com.github.sportstats.services.validation.Errors;
import com.github.sportstats.services.validation.PropertyPath;
import com.github.sportstats.services.validation.StringFormat;
import com.github.sportstats.services.validation.group.BuiltIn;
import java.time.LocalDate;
import javax.validation.constraints.*;
import org.jetbrains.annotations.Nullable;

/**
 * Contains common player information across different views.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface AbstractPlayerView {

  @NotBlank(
      message = PropertyPath.Player.FIRST_NAME + Errors.IS_EMPTY,
      groups = BuiltIn.class)
  @Pattern(
      regexp = StringFormat.NAME,
      message = PropertyPath.Player.FIRST_NAME + Errors.INVALID_FORMAT,
      groups = BuiltIn.class)
  @Size(
      max = ConstraintConstants.Player.NAME_MAX_LENGTH,
      message = PropertyPath.Player.FIRST_NAME + Errors.INVALID_SIZE,
      groups = BuiltIn.class)
  @Nullable
  String getFirstName();

  @NotBlank(
      message = PropertyPath.Player.LAST_NAME + Errors.IS_EMPTY,
      groups = BuiltIn.class)
  @Pattern(
      regexp = StringFormat.NAME,
      message = PropertyPath.Player.LAST_NAME + Errors.INVALID_FORMAT,
      groups = BuiltIn.class)
  @Size(
      max = ConstraintConstants.Player.NAME_MAX_LENGTH,
      message = PropertyPath.Player.LAST_NAME + Errors.INVALID_SIZE,
      groups = BuiltIn.class)
  @Nullable
  String getLastName();

  @NotNull(
      message = PropertyPath.Player.COUNTRY + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Nullable
  Country getCountry();

  @NotNull(
      message = PropertyPath.Player.BIRTH_DATE + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Past(
      message = PropertyPath.Player.BIRTH_DATE + Errors.NON_PAST,
      groups = BuiltIn.class)
  @Nullable
  LocalDate getBirthDate();
}