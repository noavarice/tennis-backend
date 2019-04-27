package com.github.sportstats.rest.mapper;

import com.github.sportstats.commons.mapstruct.config.DefaultMapperConfig;
import com.github.sportstats.rest.util.PagingParamsView;
import com.github.sportstats.rest.util.SortParamsView;
import com.github.sportstats.services.util.PagingParams;
import com.github.sportstats.services.util.SortParams;
import org.mapstruct.Mapper;

/**
 * Mapper for basic paging and sorting request parameters.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Mapper(config = DefaultMapperConfig.class)
public interface IRequestParamsMapper {

  PagingParams toModel(final PagingParamsView view);

  SortParams toModel(final SortParamsView view);
}
