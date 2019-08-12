package com.github.sportstats.services.validation.constraint;

import com.github.sportstats.services.validation.ResourceType;
import com.github.sportstats.services.validation.constraint.validator.ExistsById;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Checks if resource of specified type exists.
 *
 * @author noavarice
 * @since 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {
    ExistsById.class,
})
public @interface Exists {

  /**
   * Shows how to interpret validation resource identifier.
   */
  ResourceType type();

  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
