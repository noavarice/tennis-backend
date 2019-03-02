package com.github.sportstats.services.model.player;

/**
 * Contains updated information about particular player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class UpdatedPlayer extends AbstractPlayer {

  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
