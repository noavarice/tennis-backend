package com.github.sportstats.services.util;

import com.github.sportstats.commons.enumeration.SortDirection;

/**
 * Sorting request parameters.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class SortParamsView {

  private String sortBy;

  private SortDirection direction;

  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(final String sortBy) {
    this.sortBy = sortBy;
  }

  public SortDirection getDirection() {
    return direction;
  }

  public void setDirection(final SortDirection direction) {
    this.direction = direction;
  }
}
