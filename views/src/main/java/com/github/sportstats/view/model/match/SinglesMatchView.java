package com.github.sportstats.view.model.match;

import com.github.sportstats.commons.enumeration.MatchStatus;
import com.github.sportstats.view.model.player.AbstractPlayerListView;
import java.time.Instant;

/**
 * Read-only singles view.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class SinglesMatchView {

  private int id;

  private Instant startsAt;

  private AbstractPlayerListView firstPlayer;

  private AbstractPlayerListView secondPlayer;

  private MatchStatus status;

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public Instant getStartsAt() {
    return startsAt;
  }

  public void setStartsAt(final Instant startsAt) {
    this.startsAt = startsAt;
  }

  public AbstractPlayerListView getFirstPlayer() {
    return firstPlayer;
  }

  public void setFirstPlayer(final AbstractPlayerListView firstPlayer) {
    this.firstPlayer = firstPlayer;
  }

  public AbstractPlayerListView getSecondPlayer() {
    return secondPlayer;
  }

  public void setSecondPlayer(final AbstractPlayerListView secondPlayer) {
    this.secondPlayer = secondPlayer;
  }

  public MatchStatus getStatus() {
    return status;
  }

  public void setStatus(final MatchStatus status) {
    this.status = status;
  }
}
