package com.github.sportstats.entity.projection.player;


import com.github.sportstats.entity.model.PlayerEntity;

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
