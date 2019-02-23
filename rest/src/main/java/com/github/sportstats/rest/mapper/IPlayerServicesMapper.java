package com.github.sportstats.rest.mapper;

import com.github.sportstats.commons.mapper.CountryMapper;
import com.github.sportstats.commons.mapper.config.DefaultMapperConfig;
import com.github.sportstats.rest.view.NewPlayerView;
import com.github.sportstats.services.model.player.NewPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DefaultMapperConfig.class, uses = {
    CountryMapper.class,
})
public interface IPlayerServicesMapper {

  @Mapping(target = "country", source = "countryId")
  NewPlayer toModel(final NewPlayerView view);
}
