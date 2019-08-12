package com.github.sportstats.provider.model;

import com.github.sportstats.commons.enumeration.MatchStatus;
import com.github.sportstats.provider.converter.MatchDurationAttributeConverter;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;

/**
 * Match entity.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Entity(name = "matches")
public class MatchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "match_id", updatable = false)
  private Integer id;

  @Column(name = "starts_at", nullable = false)
  private Instant startsAt;

  @Column(name = "duration_min")
  @Convert(converter = MatchDurationAttributeConverter.class)
  private Duration duration;

  @Column(name = "status", nullable = false)
  private MatchStatus status;

  @OneToMany(
      mappedBy = "match",
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE,
      })
  private List<MatchParticipantEntity> participants;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "match")
  private MatchResultEntity result;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public Instant getStartsAt() {
    return startsAt;
  }

  public void setStartsAt(final Instant startsAt) {
    this.startsAt = startsAt;
  }

  public Duration getDuration() {
    return duration;
  }

  public void setDuration(final Duration duration) {
    this.duration = duration;
  }

  public MatchStatus getStatus() {
    return status;
  }

  public void setStatus(final MatchStatus status) {
    this.status = status;
  }

  public List<MatchParticipantEntity> getParticipants() {
    return participants;
  }

  public void setParticipants(final List<MatchParticipantEntity> participants) {
    this.participants = participants;
  }

  public MatchResultEntity getResult() {
    return result;
  }

  public void setResult(final MatchResultEntity result) {
    this.result = result;
  }
}
