package com.github.sportstats.services.mapper;

import com.github.sportstats.commons.enumeration.MatchStatus;
import com.github.sportstats.entity.model.MatchEntity;
import com.github.sportstats.entity.model.MatchParticipantEntity;
import com.github.sportstats.mappers.config.DefaultMapperConfig;
import com.github.sportstats.entity.id.MatchParticipantId;
import com.github.sportstats.view.model.match.AbstractNewSinglesMatchView;
import com.github.sportstats.view.model.match.SinglesMatchView;
import com.github.sportstats.view.model.player.AbstractPlayerListView;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Mappings between match models.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Mapper(config = DefaultMapperConfig.class)
public abstract class AbstractMatchMapper {

  private IPlayerServicesMapper playerMapper;

  @Autowired
  public void setBeans(final IPlayerServicesMapper playerMapper) {
    this.playerMapper = playerMapper;
  }

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "duration", ignore = true)
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "participants", ignore = true)
  @Mapping(target = "result", ignore = true)
  public abstract MatchEntity toEntity(final AbstractNewSinglesMatchView view);

  private MatchParticipantEntity getPlayer(final int playerId, final boolean isHost) {
    final var result = new MatchParticipantEntity();

    final var id = new MatchParticipantId();
    id.setPlayerId(playerId);
    result.setId(id);

    result.setHost(isHost);

    return result;
  }

  @AfterMapping
  protected void afterEntityMapping(AbstractNewSinglesMatchView view, @MappingTarget MatchEntity entity) {
    final boolean startsInFuture = view.getStartsAt().isAfter(Instant.now());
    final MatchStatus status = startsInFuture ? MatchStatus.NOT_STARTED : MatchStatus.IN_PROGRESS;
    entity.setStatus(status);

    entity.setDuration(Duration.ZERO);

    final List<MatchParticipantEntity> participants = List.of(
        getPlayer(view.getFirstPlayerId(), true),
        getPlayer(view.getSecondPlayerId(), false));
    entity.setParticipants(participants);
  }

  @Mapping(target = "firstPlayer", ignore = true)
  @Mapping(target = "secondPlayer", ignore = true)
  public abstract SinglesMatchView toView(final MatchEntity entity);

  @AfterMapping
  protected void afterViewMapping(MatchEntity entity, @MappingTarget SinglesMatchView view) {
    for (final MatchParticipantEntity participant: entity.getParticipants()) {
      final AbstractPlayerListView player = playerMapper.toListModel(participant.getPlayer());
      if (participant.isHost()) {
        view.setFirstPlayer(player);
      } else {
        view.setSecondPlayer(player);
      }
    }
  }
}
