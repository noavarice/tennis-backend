package com.github.sportstats.services.service;

/**
 * Provides method to check object existence by its ID.
 *
 * @author noavarice
 * @since 0.0.1
 */
public interface ExistsByIdService {

  boolean exists(final int id);
}
