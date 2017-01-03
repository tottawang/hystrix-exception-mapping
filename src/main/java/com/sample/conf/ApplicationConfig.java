package com.sample.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.autodesk.exception.HystrixRuntimeExceptionMapper;

@Configuration
public class ApplicationConfig extends ResourceConfig {

  public ApplicationConfig() {
    packages("com.sample.resources");
    this.register(HystrixRuntimeExceptionMapper.class);
  }
}
