package com.github.sportstats.services.util;

/**
 * Pagination request parameters.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class PagingParamsView {

  private int pageNumber;

  private int pageSize;

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(final int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize;
  }
}
