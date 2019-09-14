package com.github.sportstats.rest.controller;

import com.github.sportstats.rest.util.RestUtils;
import com.github.sportstats.services.model.match.SinglesMatchView;
import com.github.sportstats.services.model.match.NewSinglesMatchView;
import com.github.sportstats.services.service.IMatchService;
import com.github.sportstats.services.service.IPlayerService;
import com.github.sportstats.services.validation.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints to work with matches.
 *
 * @author noavarice
 * @since 0.0.1
 */
@RestController
@RequestMapping(path = "/matches")
public class MatchController {

  private final IMatchService service;

  private final IPlayerService playerService;

  @Autowired
  public MatchController(final IMatchService service, final IPlayerService playerService) {
    this.service = service;
    this.playerService = playerService;
  }

  @PostMapping(path = "/singles")
  public SinglesMatchView createSingles(@RequestBody final NewSinglesMatchView view) {
    RestUtils.exists(view.getFirstPlayerId(), ResourceType.PLAYER, playerService);
    RestUtils.exists(view.getSecondPlayerId(), ResourceType.PLAYER, playerService);
    return service.createSingles(view);
  }
}
