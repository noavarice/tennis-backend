package com.github.sportstats.commons.mapper;

import com.github.sportstats.commons.enumeration.IIdentifiedEnum;

public interface IEnumMapper<T extends Enum<T> & IIdentifiedEnum> {

  T toEnum(final Integer id);
}
