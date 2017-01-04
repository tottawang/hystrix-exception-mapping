package com.sample.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IntegrationRuntimeExceptionMapper
    implements ExceptionMapper<IntegrationRuntimeException> {

  @Override
  public Response toResponse(IntegrationRuntimeException ex) {
    return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage())
        .type(MediaType.APPLICATION_JSON).build();
  }
}
