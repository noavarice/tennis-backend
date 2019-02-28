package com.github.sportstats.rest.mapper;

import com.github.sportstats.commons.mapper.config.DefaultMapperConfig;
import com.github.sportstats.rest.view.player.NewPlayerView;
import com.github.sportstats.rest.view.player.PlayerView;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface IPlayerRestMapper {

  NewPlayer toModel(final NewPlayerView view);

  PlayerView toView(final Player model);
}
