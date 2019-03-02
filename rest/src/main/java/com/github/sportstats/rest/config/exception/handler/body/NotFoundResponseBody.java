package com.github.sportstats.rest.config.exception.handler.body;

import org.springframework.http.HttpStatus;

/**
 * Response body for {@link HttpStatus#NOT_FOUND}.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class NotFoundResponseBody {

  private final String resourceType;

  private final int resourceId;

  public NotFoundResponseBody(String resourceType, int resourceId) {
    this.resourceType = resourceType;
    this.resourceId = resourceId;
  }

  public String getResourceType() {
    return resourceType;
  }

  public int getResourceId() {
    return resourceId;
  }
}
