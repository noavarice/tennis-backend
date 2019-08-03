package com.github.sportstats.services.model.player;

/**
 * Short list model for {@link Player}.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class PlayerListModel {

  int id;

  String firstName;

  String lastName;

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
}
