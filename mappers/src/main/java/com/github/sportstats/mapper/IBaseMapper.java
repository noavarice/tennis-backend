package com.github.sportstats.mapper;

import java.util.List;

/**
 * Basic mapper between model and entity classes.
 *
 * @author noavarice
 * @since 0.0.1
 * @param <M> Model type
 * @param <LM> List model type
 * @param <E> Entity type
 * @param <LE> List entity type
 */
public interface IBaseMapper<M, LM, E, LE> {

  M toModel(final E entity);

  List<M> toModels(final Iterable<E> entities);

  E toEntity(final M model);

  List<E> toEntities(final Iterable<M> models);

  List<LM> toListModels(final Iterable<LE> entities);
}
