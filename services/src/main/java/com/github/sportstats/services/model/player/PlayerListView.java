package com.github.sportstats.services.model.player;

import org.immutables.value.Value;

/**
 * {@link PlayerView} list short view.
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
