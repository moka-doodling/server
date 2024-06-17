package com.doodling.exception.util;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorResponse {

  private final HttpStatus status;
  private final String name;
  private final String msg;
}
