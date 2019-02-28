package com.github.sportstats.commons.mapper;

import com.github.sportstats.commons.enumeration.IIdentifiedEnum;

/**
 * Performs mapping of Java enum value {@link IIdentifiedEnum#getId() ID} to the value itself.
 *
 * @param <T> Java enum type implementing {@link IIdentifiedEnum} interface
 * @author alexrazinkov
 * @since 0.0.1
 */
public interface IEnumMapper<T extends Enum<T> & IIdentifiedEnum> {

  /**
   * Maps enum value ID to the value itself.
   *
   * @param id Enum value ID
   * @return Enum value
   */
  T toEnum(final Integer id);
}
