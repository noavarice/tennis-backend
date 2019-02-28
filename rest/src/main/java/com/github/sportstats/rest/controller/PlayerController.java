package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.mapper.IPlayerRestMapper;
import com.github.sportstats.rest.validation.group.sequence.DefaultOrder;
import com.github.sportstats.rest.view.player.NewPlayerView;
import com.github.sportstats.rest.view.player.PlayerView;
import com.github.sportstats.services.service.IPlayerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/players")
@Validated
public class PlayerController {

  private final IPlayerService service;

  private final IPlayerRestMapper mapper;

  @Autowired
  public PlayerController(
      final IPlayerService service,
      final IPlayerRestMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Validated(DefaultOrder.class)
  public PlayerView create(@RequestBody @Valid final NewPlayerView view) {
    return mapper.toView(service.create(mapper.toModel(view)));
  }
}
