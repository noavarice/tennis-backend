package com.github.sportstats.rest.view.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.sportstats.commons.enumeration.Country;
import com.github.sportstats.commons.util.DateTimeUtils;
import com.github.sportstats.rest.jackson.serialization.CountryDeserializer;
import com.github.sportstats.rest.validation.ConstraintConstants;
import com.github.sportstats.rest.validation.Errors;
import com.github.sportstats.rest.validation.PropertyPath;
import com.github.sportstats.rest.validation.StringFormat;
import com.github.sportstats.rest.validation.group.BuiltIn;
import java.time.LocalDate;
import javax.validation.constraints.*;

public class NewPlayerView {

  @NotNull(
      message = PropertyPath.Player.FIRST_NAME + Errors.IS_NULL,
      groups = BuiltIn.class)
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
  private String firstName;

  @NotNull(
      message = PropertyPath.Player.LAST_NAME + Errors.IS_NULL,
      groups = BuiltIn.class)
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
  private String lastName;

  @NotNull(
      message = PropertyPath.Player.COUNTRY + Errors.IS_NULL,
      groups = BuiltIn.class)
  @JsonDeserialize(using = CountryDeserializer.class)
  private Country country;

  @NotNull(
      message = PropertyPath.Player.BIRTH_DATE + Errors.IS_NULL,
      groups = BuiltIn.class)
  @Past(
      message = PropertyPath.Player.BIRTH_DATE + Errors.NON_PAST,
      groups = BuiltIn.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.ISO_DATE_PATTERN)
  private LocalDate birthDate;

  @NotNull(
      message = PropertyPath.Player.MALE + Errors.IS_NULL,
      groups = BuiltIn.class)
  private Boolean male;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Boolean getMale() {
    return male;
  }

  public void setMale(Boolean male) {
    this.male = male;
  }
}
