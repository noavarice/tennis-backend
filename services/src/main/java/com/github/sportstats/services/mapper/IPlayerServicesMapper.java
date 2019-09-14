package com.github.sportstats.services.mapper;

import com.github.sportstats.entity.model.PlayerEntity;
import com.github.sportstats.mappers.config.DefaultMapperConfig;
import com.github.sportstats.provider.projection.player.PlayerListProjection;
import com.github.sportstats.services.model.player.NewPlayerView;
import com.github.sportstats.services.model.player.PlayerListView;
import com.github.sportstats.services.model.player.PlayerView;
import com.github.sportstats.services.model.player.UpdatedPlayerView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Declares mappings between various player classes.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Mapper(config = DefaultMapperConfig.class)
public interface IPlayerServicesMapper
    extends IBaseMapper<PlayerView, PlayerListView, PlayerEntity, PlayerListProjection> {

  @Mapping(target = "id", ignore = true)
  PlayerEntity toEntity(final NewPlayerView player);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "male", ignore = true)
  void merge(final UpdatedPlayerView player, @MappingTarget final PlayerEntity entity);

  PlayerListView toListModel(final PlayerEntity entity);
}
