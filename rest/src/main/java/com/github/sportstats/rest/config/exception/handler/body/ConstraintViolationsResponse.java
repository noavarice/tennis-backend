package com.github.sportstats.rest.config.exception.handler.body;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;

public class ConstraintViolationsResponse {

  private final List<ConstraintViolationBody> violations;

  private ConstraintViolationsResponse(final List<ConstraintViolationBody> violations) {
    this.violations = violations;
  }

  public static ConstraintViolationsResponse of(final Set<ConstraintViolation<?>> violations) {
    final List<ConstraintViolationBody> result = new ArrayList<>(violations.size());
    for (ConstraintViolation<?> violation: violations) {
      final String[] errorParts = violation.getMessage().split("_");
      result.add(new ConstraintViolationBody(errorParts[0], errorParts[1]));
    }

    return new ConstraintViolationsResponse(result);
  }

  public List<ConstraintViolationBody> getViolations() {
    return violations;
  }
}
