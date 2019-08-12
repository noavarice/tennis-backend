package com.github.sportstats.services.model.player;

import com.github.sportstats.commons.enumeration.Country;
import java.time.LocalDate;

/**
 * View containing full information about existing player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class PlayerView {

  private int id;

  private String firstName;

  private String lastName;

  private Country country;

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

  public Country getCountry() {
    return country;
  }

  public void setCountry(final Country country) {
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
