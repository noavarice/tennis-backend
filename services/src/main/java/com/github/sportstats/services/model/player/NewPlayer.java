package com.github.sportstats.services.model.player;

/**
 * Class to represent player to be added.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class NewPlayer extends AbstractPlayer {

  private boolean male;

  public boolean isMale() {
    return male;
  }

  public void setMale(boolean male) {
    this.male = male;
  }
}
