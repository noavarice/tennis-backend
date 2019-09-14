package com.github.sportstats.services.validation;

/**
 * Contains erred property path names grouped by validating entities.
 *
 * @author noavarice
 * @since 0.0.1
 * @see Errors
 */
public final class PropertyPath {

  private PropertyPath() {}

  /**
   * Property paths for player classes.
   */
  public static final class Player {

    public static final String FIRST_NAME = "player.firstName";

    public static final String LAST_NAME = "player.lastName";

    public static final String COUNTRY = "player.country";

    public static final String BIRTH_DATE = "player.birthDate";

    public static final String MALE = "player.male";
  }

  /**
   * Property paths for match classes.
   */
  public static final class Match {

    private static final String BASE_PATH = "match";

    public static final String STARTS_AT = BASE_PATH + ".startsAt";

    public static final String FIRST_PLAYER = BASE_PATH + ".firstPlayer";

    public static final String SECOND_PLAYER = BASE_PATH + ".secondPlayer";
  }
}
