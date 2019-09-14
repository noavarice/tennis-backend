package com.github.sportstats.entity.model;

import javax.persistence.*;

/**
 * Represents result of particular {@link MatchEntity match}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Entity(name = "matchResults")
public class MatchResultEntity {

  @Id
  @Column(name = "match_id")
  private Integer matchId;

  @OneToOne(optional = false)
  @JoinColumn(name = "match_id")
  @MapsId
  private MatchEntity match;

  @Column(name = "is_host_winner")
  private boolean isHostWinner;

  @Column(name = "is_technical_defeat")
  private boolean isTechnicalDefeat;

  public Integer getMatchId() {
    return matchId;
  }

  public void setMatchId(final Integer matchId) {
    this.matchId = matchId;
  }

  public MatchEntity getMatch() {
    return match;
  }

  public void setMatch(final MatchEntity match) {
    this.match = match;
  }

  public boolean isHostWinner() {
    return isHostWinner;
  }

  public void setHostWinner(final boolean hostWinner) {
    isHostWinner = hostWinner;
  }

  public boolean isTechnicalDefeat() {
    return isTechnicalDefeat;
  }

  public void setTechnicalDefeat(final boolean technicalDefeat) {
    isTechnicalDefeat = technicalDefeat;
  }
}
