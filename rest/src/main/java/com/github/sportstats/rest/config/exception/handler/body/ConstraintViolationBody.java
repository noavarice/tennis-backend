package com.github.sportstats.rest.config.exception.handler.body;

import javax.validation.ConstraintViolation;

/**
 * Response body for single {@link ConstraintViolation constraint violation}.
 *
 * @author noavarice
 * @since 0.0.1
 */
class ConstraintViolationBody {

  private final String propertyPath;

  private final String error;

  protected ConstraintViolationBody(String propertyPath, String error) {
    this.propertyPath = propertyPath;
    this.error = error;
  }

  public String getPropertyPath() {
    return propertyPath;
  }

  public String getError() {
    return error;
  }
}
