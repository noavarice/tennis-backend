package com.github.sportstats.rest.view.player;

import com.github.sportstats.rest.validation.Errors;
import com.github.sportstats.rest.validation.PropertyPath;
import com.github.sportstats.rest.validation.group.BuiltIn;
import javax.validation.constraints.NotNull;

/**
 * Input view containing information about adding player.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class NewPlayerView extends AbstractPlayerView {

  @NotNull(
      message = PropertyPath.Player.MALE + Errors.IS_NULL,
      groups = BuiltIn.class)
  private Boolean male;

  public Boolean getMale() {
    return male;
  }

  public void setMale(Boolean male) {
    this.male = male;
  }
}
