package com.github.sportstats.services.service;

import com.github.sportstats.services.model.match.AbstractNewSinglesMatchView;
import com.github.sportstats.services.model.match.SinglesMatchView;

/**
 * Service to work with matches.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface IMatchService {

  /**
   * Creates new singles match.
   *
   * @param view Singles match information
   * @return Created match information
   */
  SinglesMatchView createSingles(final AbstractNewSinglesMatchView view);
}
