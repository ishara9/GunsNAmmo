package com.zpybotlabs.gunsnammo.dto;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@ToString
@AllArgsConstructor
public class ErrorDTO {

  private final String message;
  private final ZonedDateTime zonedDateTime;

}
