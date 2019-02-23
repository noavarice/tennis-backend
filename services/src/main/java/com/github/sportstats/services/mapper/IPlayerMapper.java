package com.github.sportstats.services.mapper;

import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.services.mapper.config.ServicesMapperConfig;
import com.github.sportstats.services.model.player.NewPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = ServicesMapperConfig.class)
public interface IPlayerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "countryId", source = "country.id")
  PlayerEntity fromNewPlayer(final NewPlayer player);
}
