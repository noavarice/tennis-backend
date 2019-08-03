package com.github.sportstats.rest.util;

import java.util.List;

/**
 * View for paging requests.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class PageView<T> {

  private List<T> items;

  private long total;

  private long totalPages;

  public List<T> getItems() {
    return items;
  }

  public void setItems(final List<T> items) {
    this.items = items;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(final long total) {
    this.total = total;
  }

  public long getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(final long totalPages) {
    this.totalPages = totalPages;
  }
}
