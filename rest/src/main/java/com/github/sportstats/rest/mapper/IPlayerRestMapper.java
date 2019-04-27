package com.github.sportstats.rest.mapper;

import com.github.sportstats.commons.mapstruct.config.DefaultMapperConfig;
import com.github.sportstats.rest.util.PageView;
import com.github.sportstats.rest.view.player.NewPlayerView;
import com.github.sportstats.rest.view.player.PlayerView;
import com.github.sportstats.rest.view.player.UpdatedPlayerView;
import com.github.sportstats.services.model.player.NewPlayer;
import com.github.sportstats.services.model.player.Player;
import com.github.sportstats.services.model.player.UpdatedPlayer;
import com.github.sportstats.services.util.Page;
import org.mapstruct.Mapper;

/**
 * Declares mappings between player model and view classes.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Mapper(config = DefaultMapperConfig.class)
public interface IPlayerRestMapper {

  NewPlayer toModel(final NewPlayerView view);

  UpdatedPlayer toModel(final UpdatedPlayerView view);

  PlayerView toView(final Player model);

  PageView<PlayerView> toView(final Page<Player> model);
}
