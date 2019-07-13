package com.github.sportstats.provider.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * {@link Pageable} implementation for paging requests.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class PageableImpl implements Pageable {

  private int pageNumber;

  private int pageSize;

  private Sort sort = new Sort(Sort.Direction.ASC, "id");

  public void setPageNumber(final int pageNumber) {
    this.pageNumber = pageNumber < 1 ? 1 : pageNumber;
  }

  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize < 0 ? 10 : pageSize;
  }

  public void setSort(final Sort sort) {
    this.sort = sort;
  }

  @Override
  public int getPageNumber() {
    return pageNumber;
  }

  @Override
  public int getPageSize() {
    return pageSize;
  }

  @Override
  public long getOffset() {
    return (pageNumber - 1) * pageSize;
  }

  @Override
  public Sort getSort() {
    return sort;
  }

  @Override
  public Pageable next() {
    throw new IllegalArgumentException();
  }

  @Override
  public Pageable previousOrFirst() {
    throw new IllegalArgumentException();
  }

  @Override
  public Pageable first() {
    throw new IllegalArgumentException();
  }

  @Override
  public boolean hasPrevious() {
    throw new IllegalArgumentException();
  }
}
