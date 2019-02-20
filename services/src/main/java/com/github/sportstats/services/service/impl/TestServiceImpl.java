package com.github.sportstats.services.service.impl;

import com.github.sportstats.services.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

  @Override
  public void doSomething() {
    LOGGER.info("From services");
  }
}
