package com.github.sportstats.rest.config.exception.handler.body;

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
