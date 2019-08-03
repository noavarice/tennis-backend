package com.github.sportstats.services.service.impl;

import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.provider.projection.player.PlayerListProjection;
import com.github.sportstats.provider.repository.IPlayerRepository;
import com.github.sportstats.services.mapper.IPlayerServicesMapper;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.model.player.PlayerListModel;
import com.github.sportstats.services.model.player.UpdatedPlayer;
import com.github.sportstats.services.service.AbstractPagingService;
import com.github.sportstats.services.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link IPlayerService}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Service
public class PlayerServiceImpl
    extends AbstractPagingService<PlayerListModel, PlayerListProjection>
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
  public Player create(final NewPlayer player) {
    LOGGER.info("[Player] Creating new player");
    final Player createdPlayer = mapper.toModel(repository.save(mapper.toEntity(player)));
    LOGGER.info("[Player ID={}] Created {}", createdPlayer.getId(), createdPlayer);
    return createdPlayer;
  }

  @Override
  public Player update(final UpdatedPlayer player) {
    final int playerId = player.getId();
    LOGGER.info("[Player ID={}] Updating player", playerId);
    final PlayerEntity entity = repository
        .findById(playerId)
        .orElseThrow(() -> new IllegalArgumentException("Unknown player with ID=" + playerId));
    mapper.merge(player, entity);
    final Player updatedPlayer = mapper.toModel(repository.save(entity));
    LOGGER.info("[Player ID={}] Updated {}", playerId, updatedPlayer);
    return updatedPlayer;
  }

  @Override
  public Player getById(final int playerId) {
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
