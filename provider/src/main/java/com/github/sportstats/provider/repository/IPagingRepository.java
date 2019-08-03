package com.github.sportstats.provider.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository with paging method.
 *
 * @author noavarice
 * @since 0.0.1
 * @param <T> Entity type
 */
public interface IPagingRepository<T> {

  /**
   * @see PagingAndSortingRepository#findAll(Pageable)
   */
  Page<T> findAllProjectedBy(final Pageable pageable);
}
