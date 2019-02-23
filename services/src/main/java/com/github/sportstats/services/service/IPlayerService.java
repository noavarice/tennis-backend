package com.github.sportstats.services.service;

import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;

public interface IPlayerService {

  Player create(final NewPlayer player);
}
