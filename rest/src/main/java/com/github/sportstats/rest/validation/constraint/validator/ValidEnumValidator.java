package com.github.sportstats.rest.validation.constraint.validator;

import com.github.sportstats.commons.enumeration.IIdentifiedEnum;
import com.github.sportstats.rest.validation.constraint.ValidEnum;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEnumValidator implements ConstraintValidator<ValidEnum, Integer> {

  private Class<? extends IIdentifiedEnum> enumClass;

  @Override
  public void initialize(final ValidEnum annotation) {
    this.enumClass = annotation.enumType();
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    final IIdentifiedEnum[] values = enumClass.getEnumConstants();
    if (values == null) {
      // passed enumType is not an enum type
      return false;
    }

    return Arrays.stream(values).map(IIdentifiedEnum::getId).anyMatch(value::equals);
  }
}
