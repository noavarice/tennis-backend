package com.github.sportstats.rest.util;

import com.github.sportstats.rest.exception.NotFoundException;
import com.github.sportstats.services.service.ExistsByIdService;
import com.github.sportstats.services.validation.ResourceType;

/**
 * Contains various REST-specific methods.
 *
 * @author noavarice
 * @since 0.0.1
 */
public final class RestUtils {

  /**
   * Checks if resource with specified ID exists.
   *
   * @param resourceId Player ID
   * @throws NotFoundException In case player with such ID is not found
   */
  public static void exists(Integer resourceId, ResourceType type, ExistsByIdService service) {
    if (resourceId == null) {
      return;
    }

    if (!service.exists(resourceId)) {
      throw new NotFoundException(type, resourceId);
    }
  }
}
