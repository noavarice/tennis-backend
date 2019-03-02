package com.github.sportstats.services.model.player;

import com.github.sportstats.commons.enumeration.Country;
import java.time.LocalDate;

/**
 * Contains common player information across different models.
 *
 * @author noavarice
 * @since 0.0.1
 */
public abstract class AbstractPlayer {

  private String firstName;

  private String lastName;

  private Country country;

  private LocalDate birthDate;

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
}
