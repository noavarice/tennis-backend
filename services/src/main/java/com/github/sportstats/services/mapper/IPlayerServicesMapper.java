package com.github.sportstats.services.mapper;

import com.github.sportstats.commons.mapper.config.DefaultMapperConfig;
import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Declares mappings between various player classes.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Mapper(config = DefaultMapperConfig.class)
public interface IPlayerServicesMapper {

  @Mapping(target = "id", ignore = true)
  PlayerEntity toEntity(final NewPlayer player);

  Player toFullModel(final PlayerEntity entity);
}
