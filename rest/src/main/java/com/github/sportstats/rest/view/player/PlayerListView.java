package com.github.sportstats.rest.view.player;

import com.github.sportstats.services.model.player.Player;
import org.immutables.value.Value;

/**
 * {@link Player} list short view.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Value.Immutable
@Value.Style(with = "")
public interface PlayerListView {

  int getId();

  String getFirstName();

  String getLastName();
}
