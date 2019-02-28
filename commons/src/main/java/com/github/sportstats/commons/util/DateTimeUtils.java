package com.github.sportstats.commons.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Contains various datetime-related constants and methods.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class DateTimeUtils {

  private DateTimeUtils() {}

  /**
   * ISO format for date values.
   * Primary used for {@link LocalDate} values deserialization from JSON.
   *
   * @see DateTimeFormatter
   */
  public static final String ISO_DATE_PATTERN = "yyyy-MM-dd";
}
