package com.github.sportstats.services.mapper;

import com.github.sportstats.commons.mapstruct.config.DefaultMapperConfig;
import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.model.player.UpdatedPlayer;
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
public interface IPlayerServicesMapper extends IBaseMapper<Player, PlayerEntity> {

  @Mapping(target = "id", ignore = true)
  PlayerEntity toEntity(final NewPlayer player);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "male", ignore = true)
  void merge(final UpdatedPlayer player, @MappingTarget final PlayerEntity entity);
}
