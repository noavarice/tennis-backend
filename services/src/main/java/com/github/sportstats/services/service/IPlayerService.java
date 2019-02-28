package com.github.sportstats.services.service;

import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;

/**
 * Declares high-level operations upon players.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface IPlayerService {

  /**
   * Adds new player information.
   *
   * @param player Player information
   * @return Player information with assigned unique ID
   */
  Player create(final NewPlayer player);
}
