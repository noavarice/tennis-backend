package com.github.sportstats.commons.mapper.config;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

/**
 * Base Mapstruct {@link Mapper mapper} configuration class.
 *
 * @author noavarice
 * @since 0.0.1
 */
@MapperConfig(
  unmappedTargetPolicy = ReportingPolicy.ERROR,
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  implementationPackage = "<PACKAGE_NAME>.impl")
public class DefaultMapperConfig {}
