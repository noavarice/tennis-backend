package com.github.sportstats.services.service;

import com.github.sportstats.commons.enumeration.SortDirection;
import com.github.sportstats.provider.repository.IPagingRepository;
import com.github.sportstats.provider.util.PageableImpl;
import com.github.sportstats.services.mapper.IBaseMapper;
import com.github.sportstats.services.util.PageView;
import com.github.sportstats.services.util.PagingParamsView;
import com.github.sportstats.services.util.SortParamsView;
import java.util.List;
import org.springframework.data.domain.Sort;

/**
 * Base service with paging method.
 *
 * @param <LM> List type of entities service operates upon
 * @param <LE> Entity list type
 * @author noavarice
 * @since 0.0.1
 */
public abstract class AbstractPagingService<LM, LE> {

  private final IPagingRepository<LE> repository;

  private final IBaseMapper<?, LM, ?, LE> mapper;

  protected AbstractPagingService(
      final IPagingRepository<LE> repository,
      final IBaseMapper<?, LM, ?, LE> mapper) {
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
  public PageView<LM> getPaged(final PagingParamsView paging, final SortParamsView sort) {
    final var pageable = new PageableImpl();
    pageable.setPageSize(paging.getPageSize());
    pageable.setPageNumber(paging.getPageNumber());
    final String sortBy = sort.getSortBy();
    if (sortBy != null) {
      final SortDirection dirParam = sort.getDirection();
      final Sort.Direction dir = dirParam == null || dirParam == SortDirection.ASC
          ? Sort.Direction.ASC
          : Sort.Direction.DESC;
      pageable.setSort(Sort.by(dir, sort.getSortBy()));
    }

    final var page = repository.findAllProjectedBy(pageable);
    final List<LM> content = mapper.toListModels(page.getContent());
    return PageView.of(content, page.getTotalElements(), page.getTotalPages());
  }
}
