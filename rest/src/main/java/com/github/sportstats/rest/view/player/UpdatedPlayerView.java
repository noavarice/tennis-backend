package com.github.sportstats.rest.view.player;

/**
 * Represents request body for updated information about player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class UpdatedPlayerView extends AbstractPlayerView {

  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
