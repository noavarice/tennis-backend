package com.github.sportstats.rest.controller;

import com.github.sportstats.services.service.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  private final IPlayerService service;

  @Autowired
  public TestController(final IPlayerService service) {
    this.service = service;
  }

  @GetMapping(path = "/ping")
  public void ping() {
    logger.info("From controller");
    service.create();
  }
}
