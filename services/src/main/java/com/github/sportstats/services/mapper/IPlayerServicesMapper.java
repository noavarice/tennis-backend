package com.github.sportstats.services.mapper;

import com.github.sportstats.commons.mapper.CountryMapper;
import com.github.sportstats.commons.mapper.config.DefaultMapperConfig;
import com.github.sportstats.provider.model.PlayerEntity;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DefaultMapperConfig.class, uses = {
    CountryMapper.class,
})
public interface IPlayerServicesMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "countryId", source = "country.id")
  PlayerEntity toEntity(final NewPlayer player);

  @Mapping(target = "country", source = "countryId")
  Player toFullModel(final PlayerEntity entity);
}
