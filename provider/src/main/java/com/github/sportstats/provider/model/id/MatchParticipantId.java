package com.github.sportstats.provider.model.id;

import com.github.sportstats.provider.model.MatchParticipantEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Represents composite ID for {@link MatchParticipantEntity}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Embeddable
public class MatchParticipantId implements Serializable {

  @Column(name = "match_id", updatable = false)
  private int matchId;

  @Column(name = "player_id", updatable = false)
  private int playerId;

  public int getMatchId() {
    return matchId;
  }

  public void setMatchId(final int matchId) {
    this.matchId = matchId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(final int playerId) {
    this.playerId = playerId;
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof MatchParticipantId)) {
      return true;
    }

    final MatchParticipantId that = (MatchParticipantId) o;
    return matchId == that.matchId && playerId == that.playerId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchId, playerId);
  }
}
