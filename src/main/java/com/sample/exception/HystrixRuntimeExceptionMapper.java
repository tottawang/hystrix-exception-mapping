package com.sample.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.netflix.hystrix.exception.HystrixRuntimeException;

public class HystrixRuntimeExceptionMapper implements ExceptionMapper<HystrixRuntimeException> {

  @Override
  public Response toResponse(HystrixRuntimeException exception) {

    // we might need to log the exception here

    return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(exception)
        .type(MediaType.APPLICATION_JSON).build();
  }
}
