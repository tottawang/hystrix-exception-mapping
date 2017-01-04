package com.sample.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class IntegrationRuntimeException extends WebApplicationException {

  private static final long serialVersionUID = 1L;

  public IntegrationRuntimeException() {
    super(Response.Status.BAD_REQUEST);
  }

  public IntegrationRuntimeException(String message, Throwable e) {
    super(message, e, Response.Status.BAD_REQUEST);
  }
}

