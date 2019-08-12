package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.exception.NotFoundException;
import com.github.sportstats.services.model.player.*;
import com.github.sportstats.services.util.PagingParamsView;
import com.github.sportstats.services.util.SortParamsView;
import com.github.sportstats.services.util.PageView;
import com.github.sportstats.services.validation.ResourceType;
import com.github.sportstats.services.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Entry point for various player requests (create, update, etc).
 *
 * @author noavarice
 * @since 0.0.1
 */
@RestController
@RequestMapping(path = "/players")
public class PlayerController {

  private final IPlayerService service;

  @Autowired
  public PlayerController(final IPlayerService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PlayerView create(@RequestBody final ImmutableNewPlayerView view) {
    return service.create(view);
  }

  /**
   * Checks if player with specified ID exists.
   *
   * @param playerId Player ID
   * @throws NotFoundException In case player with such ID is not found
   */
  private void checkPlayerExists(final int playerId) {
    if (!service.exists(playerId)) {
      throw new NotFoundException(ResourceType.PLAYER, playerId);
    }
  }

  @PutMapping("/{playerId}")
  public PlayerView update(
      @PathVariable("playerId") final int playerId,
      @RequestBody final ImmutableUpdatedPlayerView player
  ) {
    checkPlayerExists(playerId);
    return service.update(player.withId(playerId));
  }

  @GetMapping(path = "/{playerId}")
  public PlayerView getById(@PathVariable("playerId") final int playerId) {
    checkPlayerExists(playerId);
    return service.getById(playerId);
  }

  @GetMapping
  public PageView<? extends PlayerListView> getPaged(final PagingParamsView paging, final SortParamsView sort) {
    return service.getPaged(paging, sort);
  }
}
