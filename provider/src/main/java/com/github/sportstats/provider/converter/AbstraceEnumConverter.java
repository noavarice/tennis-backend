package com.github.sportstats.provider.converter;

import com.github.sportstats.commons.enumeration.IIdentifiedEnum;
import javax.persistence.AttributeConverter;

/**
 * Basic {@link AttributeConverter} for {@link Enum} types.
 *
 * @author noavarice
 * @since 0.0.1
 */
abstract class AbstraceEnumConverter<T extends Enum<T> & IIdentifiedEnum>
    implements AttributeConverter<T, Integer> {

  @Override
  public Integer convertToDatabaseColumn(T attribute) {
    return attribute.getId();
  }
}
