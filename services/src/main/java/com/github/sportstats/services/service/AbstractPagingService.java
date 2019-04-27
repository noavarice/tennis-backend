package com.github.sportstats.services.service;

import com.github.sportstats.commons.enumeration.SortDirection;
import com.github.sportstats.provider.repository.IPagingRepository;
import com.github.sportstats.provider.util.PageableImpl;
import com.github.sportstats.services.mapper.IBaseMapper;
import com.github.sportstats.services.util.Page;
import com.github.sportstats.services.util.PagingParams;
import com.github.sportstats.services.util.SortParams;
import org.springframework.data.domain.Sort;

/**
 * Base service with paging method.
 *
 * @param <T> Type of entities service operates upon
 * @param <E> Entity type
 * @author noavarice
 * @since 0.0.1
 */
public abstract class AbstractPagingService<T, E> {

  private final IPagingRepository<E> repository;

  private final IBaseMapper<T, E> mapper;

  protected AbstractPagingService(
      final IPagingRepository<E> repository,
      final IBaseMapper<T, E> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  /**
   * Returns paged entities information.
   *
   * @param paging Paging parameters
   * @param sort Sorting parameters
   * @return Paged information
   */
  public Page<T> getPaged(final PagingParams paging, final SortParams sort) {
    final var pageable = new PageableImpl();
    pageable.setPageSize(paging.getPageSize());
    pageable.setPageNumber(paging.getPageNumber());
    final SortDirection dirParam = sort.getDirection();
    final Sort.Direction dir = dirParam == null || dirParam == SortDirection.ASC
        ? Sort.Direction.ASC
        : Sort.Direction.DESC;
    pageable.setSort(Sort.by(dir, sort.getSortBy()));
    final var page = repository.findAll(pageable);
    return Page.of(mapper.toModels(page.getContent()), page.getTotalElements());
  }
}
