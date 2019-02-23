package com.github.sportstats.rest.view;

import java.time.LocalDate;

public class NewPlayerView {

  private String firstName;

  private String lastName;

  private Integer countryId;

  private LocalDate birthDate;

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

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
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
