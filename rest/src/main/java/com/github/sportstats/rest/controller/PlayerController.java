package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.exception.NotFoundException;
import com.github.sportstats.rest.mapper.IPlayerRestMapper;
import com.github.sportstats.rest.mapper.IRequestParamsMapper;
import com.github.sportstats.rest.util.PagingParamsView;
import com.github.sportstats.rest.util.SortParamsView;
import com.github.sportstats.rest.util.PageView;
import com.github.sportstats.rest.validation.ResourceType;
import com.github.sportstats.rest.validation.ValidatorProxy;
import com.github.sportstats.rest.validation.group.sequence.DefaultOrder;
import com.github.sportstats.rest.view.player.*;
import com.github.sportstats.services.service.IPlayerService;
import com.github.sportstats.services.util.PagingParams;
import com.github.sportstats.services.util.SortParams;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Entry point for various player requests (create, update, etc).
 *
 * @author noavarice
 * @since 0.0.1
 */
@RestController
@RequestMapping(path = "/players")
@Validated
public class PlayerController {

  private final IPlayerService service;

  private final IPlayerRestMapper mapper;

  private final ValidatorProxy validatorProxy;

  private final IRequestParamsMapper paramsMapper;

  @Autowired
  public PlayerController(
      final IPlayerService service,
      final IPlayerRestMapper mapper,
      final ValidatorProxy validatorProxy,
      final IRequestParamsMapper paramsMapper) {
    this.service = service;
    this.mapper = mapper;
    this.validatorProxy = validatorProxy;
    this.paramsMapper = paramsMapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Validated(DefaultOrder.class)
  public PlayerView create(@RequestBody @Valid final ImmutableNewPlayerView view) {
    return mapper.toView(service.create(mapper.toModel(view)));
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
    final UpdatedPlayerView playerWithId = player.withId(playerId);
    validatorProxy.validate(playerWithId, DefaultOrder.class);
    return mapper.toView(service.update(mapper.toModel(playerWithId)));
  }

  @GetMapping(path = "/{playerId}")
  public PlayerView getById(@PathVariable("playerId") final int playerId) {
    checkPlayerExists(playerId);
    return mapper.toView(service.getById(playerId));
  }

  @GetMapping
  public PageView<? extends PlayerListView> getPaged(final PagingParamsView paging, final SortParamsView sort) {
    final PagingParams pagingModel = paramsMapper.toModel(paging);
    final SortParams sortModel = paramsMapper.toModel(sort);
    return mapper.toListViews(service.getPaged(pagingModel, sortModel));
  }
}
