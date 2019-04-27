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

  private Page(final List<T> items, final long total) {
    this.items = items;
    this.total = total;
  }

  public static <T> Page<T> of(final List<T> items, final long total) {
    return new Page<>(items, total);
  }

  public List<T> getItems() {
    return items;
  }

  public long getTotal() {
    return total;
  }
}
