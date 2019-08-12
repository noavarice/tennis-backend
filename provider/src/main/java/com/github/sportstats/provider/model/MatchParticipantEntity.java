package com.github.sportstats.provider.model;

import com.github.sportstats.provider.model.id.MatchParticipantId;
import javax.persistence.*;
import org.hibernate.annotations.Immutable;

/**
 * Match participant entity.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Entity(name = "matchParticipants")
@Immutable
public class MatchParticipantEntity {

  @Id
  private MatchParticipantId id;

  @MapsId("playerId")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "player_id", nullable = false)
  private PlayerEntity player;

  @MapsId("matchId")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "match_id", nullable = false)
  private MatchEntity match;

  @Column(name = "is_host")
  private boolean isHost;

  public MatchParticipantId getId() {
    return id;
  }

  public void setId(final MatchParticipantId id) {
    this.id = id;
  }

  public PlayerEntity getPlayer() {
    return player;
  }

  public void setPlayer(final PlayerEntity player) {
    this.player = player;
  }

  public MatchEntity getMatch() {
    return match;
  }

  public void setMatch(final MatchEntity match) {
    this.match = match;
  }

  public boolean isHost() {
    return isHost;
  }

  public void setHost(final boolean host) {
    isHost = host;
  }
}
