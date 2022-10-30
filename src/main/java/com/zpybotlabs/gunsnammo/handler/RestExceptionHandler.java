package com.zpybotlabs.gunsnammo.handler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.zpybotlabs.gunsnammo.dto.ErrorDTO;
import com.zpybotlabs.gunsnammo.exception.ClientRequestException;
import com.zpybotlabs.gunsnammo.exception.ServerRequestException;
import java.time.ZonedDateTime;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

  @ExceptionHandler(value = { ClientRequestException.class, ConstraintViolationException.class})
  public ResponseEntity<ErrorDTO> handleClientRequestException(RuntimeException e,
      WebRequest request) {
    ErrorDTO errorDTO = new ErrorDTO(
        e.getMessage(),
        ZonedDateTime.now()
    );
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = ServerRequestException.class)
  public ResponseEntity<ErrorDTO> handleServerRequestException(ServerRequestException e,
      WebRequest request) {
    ErrorDTO errorDTO = new ErrorDTO(
        INTERNAL_SERVER_ERROR.getReasonPhrase(),
        ZonedDateTime.now()
    );
    log.error(e.getMessage(), e);
    return new ResponseEntity<>(errorDTO, INTERNAL_SERVER_ERROR);
  }

}
