package com.github.sportstats.services.service.impl;

import com.github.sportstats.provider.model.MatchEntity;
import com.github.sportstats.provider.repository.IMatchRepository;
import com.github.sportstats.services.mapper.AbstractMatchMapper;
import com.github.sportstats.services.model.match.AbstractNewSinglesMatchView;
import com.github.sportstats.services.model.match.SinglesMatchView;
import com.github.sportstats.services.service.IMatchService;
import com.github.sportstats.services.validation.group.sequence.DefaultOrder;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Default implementation for {@link IMatchService}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Service
@Validated
public class MatchServiceImpl implements IMatchService {

  private final IMatchRepository repository;

  private final AbstractMatchMapper mapper;

  @Autowired
  public MatchServiceImpl(
      final IMatchRepository repository,
      final AbstractMatchMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  @Validated(DefaultOrder.class)
  public SinglesMatchView createSingles(@Valid final AbstractNewSinglesMatchView view) {
    final MatchEntity entity = mapper.toEntity(view);
    final MatchEntity result = repository.save(entity);
    return mapper.toView(result);
  }
}
