package com.github.sportstats.rest.view.player;

import com.github.sportstats.rest.validation.Errors;
import com.github.sportstats.rest.validation.PropertyPath;
import com.github.sportstats.rest.validation.constraint.Exists;
import com.github.sportstats.rest.validation.group.Required;

/**
 * Represents request body for updated information about player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class UpdatedPlayerView extends AbstractPlayerView {

  @Exists(
      type = Exists.Type.PLAYER,
      message = PropertyPath.Player.PLAYER + Errors.NOT_EXISTS,
      groups = Required.class)
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
