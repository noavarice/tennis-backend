package com.github.sportstats.commons.mapper.config;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
  unmappedTargetPolicy = ReportingPolicy.ERROR,
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  implementationPackage = "<PACKAGE_NAME>.impl")
public class DefaultMapperConfig {}
