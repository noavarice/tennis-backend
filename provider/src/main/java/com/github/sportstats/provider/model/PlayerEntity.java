package com.github.sportstats.provider.model;

import com.github.sportstats.commons.enumeration.Country;
import com.github.sportstats.provider.converter.CountryAttributeConverter;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Player {@link Entity entity} class.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Entity(name = "players")
public class PlayerEntity implements IEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "players_seq")
  @Column(name = "player_id")
  private Integer id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(updatable = false)
  private boolean male;

  @Convert(converter = CountryAttributeConverter.class)
  @Column(name = "country_id", nullable = false)
  private Country country;

  @Column(nullable = false)
  private LocalDate birthDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public boolean isMale() {
    return male;
  }

  public void setMale(boolean male) {
    this.male = male;
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
