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
}
