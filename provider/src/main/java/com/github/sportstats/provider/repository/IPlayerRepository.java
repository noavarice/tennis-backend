package com.github.sportstats.provider.repository;

import com.github.sportstats.provider.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Contains database-level operations upon {@link PlayerEntity player entities}.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface IPlayerRepository extends JpaRepository<PlayerEntity, Integer> {}
