package com.github.sportstats.services.service.impl;

import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.provider.projection.player.PlayerListProjection;
import com.github.sportstats.provider.repository.IPlayerRepository;
import com.github.sportstats.services.mapper.IPlayerServicesMapper;
import com.github.sportstats.services.model.player.NewPlayerView;
import com.github.sportstats.services.model.player.PlayerListView;
import com.github.sportstats.services.model.player.PlayerView;
import com.github.sportstats.services.model.player.UpdatedPlayerView;
import com.github.sportstats.services.service.AbstractPagingService;
import com.github.sportstats.services.service.IPlayerService;
import com.github.sportstats.services.validation.group.sequence.DefaultOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Default implementation of {@link IPlayerService}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Service
@Validated
public class PlayerServiceImpl
    extends AbstractPagingService<PlayerListView, PlayerListProjection>
    implements IPlayerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

  private final IPlayerRepository repository;

  private final IPlayerServicesMapper mapper;

  @Autowired
  public PlayerServiceImpl(
      final IPlayerRepository repository,
      final IPlayerServicesMapper mapper) {
    super(repository, mapper);
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  @Validated(DefaultOrder.class)
  public PlayerView create(final NewPlayerView player) {
    LOGGER.info("[Player] Creating new player");
    final PlayerView createdPlayer = mapper.toModel(repository.save(mapper.toEntity(player)));
    LOGGER.info("[Player ID={}] Created {}", createdPlayer.getId(), createdPlayer);
    return createdPlayer;
  }

  @Override
  @Validated(DefaultOrder.class)
  public PlayerView update(final UpdatedPlayerView player) {
    final int playerId = player.getId().orElseThrow();
    LOGGER.info("[Player ID={}] Updating player", playerId);
    final PlayerEntity entity = repository
        .findById(playerId)
        .orElseThrow(() -> new IllegalArgumentException("Unknown player with ID=" + playerId));
    mapper.merge(player, entity);
    final PlayerView updatedPlayer = mapper.toModel(repository.save(entity));
    LOGGER.info("[Player ID={}] Updated {}", playerId, updatedPlayer);
    return updatedPlayer;
  }

  @Override
  public PlayerView getById(final int playerId) {
    return repository
        .findById(playerId)
        .map(mapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("Unknown player with ID=" + playerId));
  }

  @Override
  public boolean exists(final int id) {
    return repository.existsById(id);
  }
}
