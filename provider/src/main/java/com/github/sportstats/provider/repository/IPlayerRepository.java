package com.github.sportstats.provider.repository;

import com.github.sportstats.provider.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Contains database-level operations upon {@link PlayerEntity player entities}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@RepositoryDefinition(domainClass = PlayerEntity.class, idClass = Integer.class)
public interface IPlayerRepository {

  /**
   * @see JpaRepository#save(Object)
   */
  PlayerEntity save(final PlayerEntity entity);
}
