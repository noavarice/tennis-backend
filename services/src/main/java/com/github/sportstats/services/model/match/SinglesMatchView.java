package com.github.sportstats.services.model.match;

import com.github.sportstats.commons.enumeration.MatchStatus;
import com.github.sportstats.provider.model.MatchEntity;
import com.github.sportstats.services.model.player.PlayerListView;
import java.time.Instant;

/**
 * Read-only {@link MatchEntity match} singles view.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class SinglesMatchView {

  private int id;

  private Instant startsAt;

  private PlayerListView firstPlayer;

  private PlayerListView secondPlayer;

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

  public PlayerListView getFirstPlayer() {
    return firstPlayer;
  }

  public void setFirstPlayer(final PlayerListView firstPlayer) {
    this.firstPlayer = firstPlayer;
  }

  public PlayerListView getSecondPlayer() {
    return secondPlayer;
  }

  public void setSecondPlayer(final PlayerListView secondPlayer) {
    this.secondPlayer = secondPlayer;
  }

  public MatchStatus getStatus() {
    return status;
  }

  public void setStatus(final MatchStatus status) {
    this.status = status;
  }
}
