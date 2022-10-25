package com.zpybotlabs.gunsnammo.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = ClientRequestException.class)
  public ResponseEntity<ApiException> handleClientRequestException(ClientRequestException e,
      WebRequest request) {
    ApiException apiException = new ApiException(
        e.getMessage(),
        null,
        HttpStatus.BAD_REQUEST,
        ZonedDateTime.now()
    );
    return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = ServerRequestException.class)
  public ResponseEntity<ApiException> handleServerRequestException(ServerRequestException e,
      WebRequest request) {
    ApiException apiException = new ApiException(
        e.getMessage(),
        null,
        HttpStatus.INTERNAL_SERVER_ERROR,
        ZonedDateTime.now()
    );
    return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
