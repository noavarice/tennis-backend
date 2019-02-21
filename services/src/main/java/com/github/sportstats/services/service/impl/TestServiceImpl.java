package com.github.sportstats.services.service.impl;

import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.provider.repository.IPlayerRepository;
import com.github.sportstats.services.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

  private final IPlayerRepository repository;

  public TestServiceImpl(IPlayerRepository repository) {
    this.repository = repository;
  }

  @Override
  public void doSomething() {
    LOGGER.info("From services");
    final var entity = new PlayerEntity();
    entity.setCountryId(1);
    entity.setFirstName("Test");
    entity.setLastName("tset");
    entity.setMale(true);
    repository.save(entity);
  }
}
