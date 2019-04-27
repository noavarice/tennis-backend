package com.github.sportstats.services.mapper;

import java.util.List;

/**
 * Basic mapper between model and entity classes.
 *
 * @author noavarice
 * @since 0.0.1
 * @param <M> Model type
 * @param <E> Entity type
 */
public interface IBaseMapper<M, E> {

  M toModel(final E entity);

  List<M> toModels(final Iterable<E> entities);

  E toEntity(final M model);

  List<E> toEntities(final Iterable<M> models);
}
