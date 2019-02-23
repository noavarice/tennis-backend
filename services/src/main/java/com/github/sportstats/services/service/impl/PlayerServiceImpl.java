package com.github.sportstats.services.service.impl;

import com.github.sportstats.commons.Country;
import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.provider.repository.IPlayerRepository;
import com.github.sportstats.services.mapper.IPlayerMapper;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.service.IPlayerService;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements IPlayerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

  private final IPlayerRepository repository;

  private final IPlayerMapper mapper;

  @Autowired
  public PlayerServiceImpl(
    final IPlayerRepository repository,
    final IPlayerMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public void create() {
    LOGGER.info("From services");
    final var newPlayer = new NewPlayer();
    newPlayer.setFirstName("Test");
    newPlayer.setLastName("tset");
    newPlayer.setCountry(Country.RU);
    newPlayer.setBirthDate(LocalDate.of(1990, 1, 1));
    newPlayer.setMale(true);
    repository.save(mapper.fromNewPlayer(newPlayer));
  }
}
