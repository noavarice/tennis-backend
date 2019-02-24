package com.github.sportstats.rest.validation.constraint;

import com.github.sportstats.commons.enumeration.IIdentifiedEnum;
import com.github.sportstats.rest.validation.constraint.validator.ValidEnumValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {
    ValidEnumValidator.class,
})
public @interface ValidEnum {

  Class<? extends IIdentifiedEnum> enumType();

  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
