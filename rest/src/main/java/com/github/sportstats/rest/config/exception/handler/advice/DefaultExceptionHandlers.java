package com.github.sportstats.rest.config.exception.handler.advice;

import com.github.sportstats.rest.config.exception.handler.body.ConstraintViolationsResponse;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Contains various {@link ExceptionHandler exception handlers}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@ControllerAdvice
public class DefaultExceptionHandlers {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ConstraintViolationsResponse> handleConstraintViolation(final ConstraintViolationException e) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(ConstraintViolationsResponse.of(e.getConstraintViolations()));
  }
}
