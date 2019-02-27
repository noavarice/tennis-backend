package com.github.sportstats.rest.view.player;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.sportstats.commons.util.DateTimeUtils;
import com.github.sportstats.rest.view.SimpleView;
import java.time.LocalDate;

public class PlayerView {

  private int id;

  private String firstName;

  private String lastName;

  private SimpleView country;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtils.ISO_DATE_PATTERN)
  private LocalDate birthDate;

  private boolean male;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public SimpleView getCountry() {
    return country;
  }

  public void setCountry(SimpleView country) {
    this.country = country;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public boolean isMale() {
    return male;
  }

  public void setMale(boolean male) {
    this.male = male;
  }
}
