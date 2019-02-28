package com.github.sportstats.rest.validation;

/**
 * Contains description error codes to be used as second part of constraint violation messages.
 *
 * @author noavarice
 * @since 0.0.1
 * @see PropertyPath
 */
public final class Errors {

  private Errors() {}

  public static final String IS_NULL = "_isNull";

  public static final String IS_EMPTY = "_isEmpty";

  public static final String INVALID_FORMAT = "_invalidFormat";

  public static final String INVALID_SIZE = "_invalidSize";

  public static final String NON_PAST = "_pastDate";
}
