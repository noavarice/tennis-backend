package com.github.sportstats.provider.repository;

import com.github.sportstats.entity.model.PlayerEntity;
import com.github.sportstats.entity.projection.player.PlayerListProjection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Contains database-level operations upon {@link PlayerEntity player entities}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@RepositoryDefinition(domainClass = PlayerEntity.class, idClass = Integer.class)
public interface IPlayerRepository extends IPagingRepository<PlayerListProjection> {

  /**
   * @see JpaRepository#save(Object)
   */
  PlayerEntity save(final PlayerEntity entity);

  /**
   * @see JpaRepository#findById(Object)
   */
  Optional<PlayerEntity> findById(final int id);

  /**
   * Checks if {@link PlayerEntity} with specified {@code id} exists.
   *
   * @param id Player ID
   * @return {@literal true} if player with such ID exists and {@literal false} otherwise
   */
  boolean existsById(final int id);
}
