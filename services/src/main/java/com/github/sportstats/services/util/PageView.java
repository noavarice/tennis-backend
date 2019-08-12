package com.github.sportstats.services.util;

import java.util.List;

/**
 * View for paging requests.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class PageView<T> {

  public static <T> PageView<T> of(final List<T> items, final long total, final long totalPages) {
    return new PageView<>(List.copyOf(items), total, totalPages);
  }

  private final List<T> items;

  private final long total;

  private final long totalPages;

  private PageView(final List<T> items, final long total, final long totalPages) {
    this.items = items;
    this.total = total;
    this.totalPages = totalPages;
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
