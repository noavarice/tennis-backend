package com.github.sportstats.services.model.player;

import com.github.sportstats.commons.enumeration.Country;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents information about already existing player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class Player {

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

  public void setCountry(Country country) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return id == player.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Player{id=" + id + ", " + firstName +
        " " + lastName +
        ", " + country.getCode() +
        ", birth date: " + birthDate +
        ", " + (male ? "male" : "female") + '}';
  }
}
