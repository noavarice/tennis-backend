package com.github.sportstats.rest.validation;

import javax.validation.ConstraintViolationException;

/**
 * Interface providing validation facility where method interception is not possible.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface ValidatorProxy {

  /**
   * Performs validation of passed object based on groups.
   *
   * @param validationTarget Object to validate
   * @param groups Validation groups
   * @throws ConstraintViolationException In case if any violations were found
   */
  <T> void validate(final T validationTarget, final Class<?>... groups);
}
