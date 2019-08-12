package com.github.sportstats.rest.exception;

import com.github.sportstats.services.validation.ResourceType;

/**
 * Exception throwing if target resource is not found.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class NotFoundException extends RuntimeException {

  private final ResourceType type;

  private final int resourceId;

  public NotFoundException(final ResourceType type, final int resourceId) {
    this.type = type;
    this.resourceId = resourceId;
  }

  public ResourceType getType() {
    return type;
  }

  public int getResourceId() {
    return resourceId;
  }
}
