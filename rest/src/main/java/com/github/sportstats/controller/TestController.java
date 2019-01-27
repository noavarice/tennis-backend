package com.github.sportstats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {

  @GetMapping(path = "/ping")
  public void ping() {
    System.out.println("Hello, world!");
  }
}
