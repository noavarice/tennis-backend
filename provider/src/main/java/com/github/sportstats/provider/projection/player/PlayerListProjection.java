package com.github.sportstats.provider.projection.player;

import com.github.sportstats.provider.model.PlayerEntity;

/**
 * Simple list projection for {@link PlayerEntity}.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface PlayerListProjection {

  int getId();

  String getFirstName();

  String getLastName();
}
