package com.sample.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.sample.exception.HystrixRuntimeExceptionMapper;
import com.sample.exception.IntegrationRuntimeExceptionMapper;

@Configuration
public class ApplicationConfig extends ResourceConfig {

  public ApplicationConfig() {
    packages("com.sample.conf", "com.sample.resources", "com.sample.service");
    register(HystrixRuntimeExceptionMapper.class);
    register(IntegrationRuntimeExceptionMapper.class);
  }
}
