package com.github.sportstats.services.validation.constraint.validator;

import com.github.sportstats.services.validation.constraint.Exists;
import com.github.sportstats.services.service.ExistsByIdService;
import com.github.sportstats.services.service.IPlayerService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Checks if object {@link Exists exists} by its ID.
 *
 * @author noavarice
 * @since 0.0.1
 */
public class ExistsById implements ConstraintValidator<Exists, Integer> {

  private final IPlayerService playerService;

  private ExistsByIdService targetService;

  @Autowired
  public ExistsById(
      final IPlayerService playerService) {
    this.playerService = playerService;
  }

  @Override
  public void initialize(final Exists annotation) {
    switch (annotation.type()) {
      case PLAYER:
        targetService = playerService;
        break;

      default:
        throw new IllegalArgumentException("Unsupported resource type: " + annotation.type());
    }
  }

  @Override
  public boolean isValid(final Integer id, final ConstraintValidatorContext context) {
    if (id == null) {
      return true;
    }

    return targetService.exists(id);
  }
}
