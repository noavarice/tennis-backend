package com.github.sportstats.rest.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default {@link ValidatorProxy} implementation that wraps found violations to exception.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Service
public class ValidatorProxyImpl implements ValidatorProxy {

  private final Validator validator;

  @Autowired
  public ValidatorProxyImpl(final Validator validator) {
    this.validator = validator;
  }

  @Override
  public <T> void validate(final T validationTarget, final Class<?>... groups) {
    final Set<ConstraintViolation<T>> violations = validator.validate(validationTarget, groups);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }
}
