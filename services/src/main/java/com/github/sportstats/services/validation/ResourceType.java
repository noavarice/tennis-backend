package com.github.sportstats.services.validation;

/**
 * Possible types of resources.
 *
 * @author noavarice
 * @since 0.0.1
 */
public enum ResourceType {

  PLAYER("Player"),
  ;

  private final String name;

  ResourceType(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
