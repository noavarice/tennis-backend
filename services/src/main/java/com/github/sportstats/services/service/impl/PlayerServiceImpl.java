package com.github.sportstats.services.service.impl;

import com.github.sportstats.provider.repository.IPlayerRepository;
import com.github.sportstats.services.mapper.IPlayerServicesMapper;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements IPlayerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

  private final IPlayerRepository repository;

  private final IPlayerServicesMapper mapper;

  @Autowired
  public PlayerServiceImpl(
    final IPlayerRepository repository,
    final IPlayerServicesMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Player create(final NewPlayer player) {
    LOGGER.info("[Player] Creating new player");
    final Player createdPlayer = mapper.toFullModel(repository.save(mapper.toEntity(player)));
    LOGGER.info("[Player ID={}] Created {}", createdPlayer.getId(), createdPlayer);
    return createdPlayer;
  }
}
