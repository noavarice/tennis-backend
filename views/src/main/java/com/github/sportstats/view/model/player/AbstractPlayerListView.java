package com.github.sportstats.view.model.player;

import org.immutables.value.Value;

/**
 * {@link PlayerView} list short view.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Value.Immutable(copy = false)
@Value.Style(with = "", from = "getCopy", typeImmutable = "PlayerListView")
public interface AbstractPlayerListView {

  int getId();

  String getFirstName();

  String getLastName();
}
