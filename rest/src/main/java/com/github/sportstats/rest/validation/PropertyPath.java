package com.github.sportstats.rest.validation;

/**
 * Contains erred property path names grouped by validating entities.
 */
public final class PropertyPath {

  private PropertyPath() {}

  public static final class Player {

    public static final String FIRST_NAME = "player.firstName";

    public static final String LAST_NAME = "player.lastName";

    public static final String COUNTRY = "player.country";

    public static final String BIRTH_DATE = "player.birthDate";

    public static final String MALE = "player.male";
  }
}
