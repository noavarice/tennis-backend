package com.github.sportstats.rest.validation.constraint;

import com.github.sportstats.rest.validation.constraint.validator.ExistsById;
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
   * Types of resources.
   */
  enum Type {

    PLAYER,
    ;
  }

  /**
   * Shows how to interpret validation resource identifier.
   */
  Type type();

  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
