package com.github.sportstats.commons.enumeration;

import java.util.Optional;

/**
 * Match status.
 *
 * @author noavarice
 * @since 0.0.1
 */
public enum MatchStatus {

  NOT_STARTED(1, "Not Started"),
  IN_PROGRESS(2, "In Progress"),
  PAUSED(3, "Paused"),
  CANCELLED(4, "Cancelled"),
  FINISHED(5, "Finished");

  private final int id;

  private final String description;

  MatchStatus(final int id, final String description) {
    this.id = id;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public static Optional<MatchStatus> of(final Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (final MatchStatus status: values()) {
      if (id.equals(status.id)) {
        return Optional.of(status);
      }
    }

    return Optional.empty();
  }
}
