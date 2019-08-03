package com.github.sportstats.services.util;

import java.util.List;

/**
 * Represents result of paging requests.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class Page<T> {

  private final List<T> items;

  private final long total;

  private final long totalPages;

  private Page(final List<T> items, final long total, final long totalPages) {
    this.items = items;
    this.total = total;
    this.totalPages = totalPages;
  }

  public static <T> Page<T> of(final List<T> items, final long total, final long totalPages) {
    return new Page<>(items, total, totalPages);
  }

  public List<T> getItems() {
    return items;
  }

  public long getTotal() {
    return total;
  }

  public long getTotalPages() {
    return totalPages;
  }
}
