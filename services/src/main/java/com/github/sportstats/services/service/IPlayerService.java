package com.github.sportstats.services.service;

import com.github.sportstats.view.model.player.*;
import com.github.sportstats.services.util.PageView;
import com.github.sportstats.services.util.PagingParamsView;
import com.github.sportstats.services.util.SortParamsView;
import javax.validation.Valid;

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
  PlayerView create(@Valid final NewPlayerView player);

  /**
   * Updates information about existing player.
   *
   * @param player Updated player information
   * @return Updated player
   * @throws IllegalArgumentException If player with such {@code playerId} does not exist
   */
  PlayerView update(@Valid final UpdatedPlayerView player);

  /**
   * Retrieves player with specified ID.
   *
   * @param playerId Player ID
   * @return Player information
   * @throws IllegalArgumentException If player with such {@code playerId} does not exist
   */
  PlayerView getById(final int playerId);

  /**
   * @see AbstractPagingService#getPaged(PagingParamsView, SortParamsView)
   */
  PageView<PlayerListView> getPaged(final PagingParamsView paging, final SortParamsView sort);
}
