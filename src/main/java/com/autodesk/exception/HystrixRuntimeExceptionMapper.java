package com.autodesk.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.netflix.hystrix.exception.HystrixRuntimeException;

@Provider
public class HystrixRuntimeExceptionMapper implements ExceptionMapper<HystrixRuntimeException> {

  @Override
  public Response toResponse(HystrixRuntimeException exception) {

    // we might need to log the exception here

    return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(exception.getMessage())
        .type(MediaType.APPLICATION_JSON).build();
  }
}
