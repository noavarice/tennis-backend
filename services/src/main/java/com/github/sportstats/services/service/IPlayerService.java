package com.github.sportstats.services.service;

import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.model.player.UpdatedPlayer;

/**
 * Declares high-level operations upon players.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface IPlayerService extends ExistsByIdService {

  /**
   * Adds new player information.
   *
   * @param player Player information
   * @return Player information with assigned unique ID
   */
  Player create(final NewPlayer player);

  /**
   * Updates information about existing player.
   *
   * @param player Updated player information
   * @return Updated player
   */
  Player update(final UpdatedPlayer player);
}
