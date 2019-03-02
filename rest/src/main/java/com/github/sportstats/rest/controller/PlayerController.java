package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.exception.NotFoundException;
import com.github.sportstats.rest.mapper.IPlayerRestMapper;
import com.github.sportstats.rest.validation.ResourceType;
import com.github.sportstats.rest.validation.ValidatorProxy;
import com.github.sportstats.rest.validation.group.sequence.DefaultOrder;
import com.github.sportstats.rest.view.player.NewPlayerView;
import com.github.sportstats.rest.view.player.PlayerView;
import com.github.sportstats.rest.view.player.UpdatedPlayerView;
import com.github.sportstats.services.service.IPlayerService;
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

  @Autowired
  public PlayerController(
      final IPlayerService service,
      final IPlayerRestMapper mapper,
      final ValidatorProxy validatorProxy) {
    this.service = service;
    this.mapper = mapper;
    this.validatorProxy = validatorProxy;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Validated(DefaultOrder.class)
  public PlayerView create(@RequestBody @Valid final NewPlayerView view) {
    return mapper.toView(service.create(mapper.toModel(view)));
  }

  @PutMapping("/{playerId}")
  public PlayerView update(
      @PathVariable("playerId") final int playerId,
      @RequestBody final UpdatedPlayerView player
  ) {
    player.setId(playerId);
    if (!service.exists(playerId)) {
      throw new NotFoundException(ResourceType.PLAYER, playerId);
    }

    validatorProxy.validate(player, DefaultOrder.class);
    return mapper.toView(service.update(mapper.toModel(player)));
  }
}
