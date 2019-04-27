package com.github.sportstats.services.service;

import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.model.player.UpdatedPlayer;
import com.github.sportstats.services.util.Page;
import com.github.sportstats.services.util.PagingParams;
import com.github.sportstats.services.util.SortParams;

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
   * @throws IllegalArgumentException If player with such {@code playerId} does not exist
   */
  Player update(final UpdatedPlayer player);

  /**
   * Retrieves player with specified ID.
   *
   * @param playerId Player ID
   * @return Player information
   * @throws IllegalArgumentException If player with such {@code playerId} does not exist
   */
  Player getById(final int playerId);

  /**
   * @see AbstractPagingService#getPaged(PagingParams, SortParams)
   */
  Page<Player> getPaged(final PagingParams paging, final SortParams sort);
}
