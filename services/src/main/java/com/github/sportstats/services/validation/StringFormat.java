package com.github.sportstats.services.validation;

/**
 * Contains various regexp patterns to be used for validation purposes.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class StringFormat {

  private StringFormat() {}

  /**
   * Simple pattern for string tokens consisting of letters and spaces only.
   */
  public static final String NAME = "^[A-Za-z ]+$";
}
