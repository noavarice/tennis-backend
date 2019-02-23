package com.github.sportstats.services.mapper.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
  unmappedTargetPolicy = ReportingPolicy.ERROR,
  componentModel = "spring",
  implementationPackage = "<PACKAGE_NAME>.impl")
public class ServicesMapperConfig {}
