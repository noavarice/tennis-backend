package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.mapper.IPlayerServicesMapper;
import com.github.sportstats.rest.view.NewPlayerView;
import com.github.sportstats.services.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {

  private final IPlayerService service;

  private final IPlayerServicesMapper mapper;

  @Autowired
  public PlayerController(
      final IPlayerService service,
      final IPlayerServicesMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public void create(@RequestBody final NewPlayerView view) {
    service.create(mapper.toModel(view));
  }
}
