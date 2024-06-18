package com.doodling.aop;

import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
    log.error("CustomException occurred: {}", e.getErrorCode().getDetail());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }
}
