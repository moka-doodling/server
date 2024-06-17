package com.doodling.exception;

import com.doodling.exception.util.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {

  private final ErrorCode errorCode;
}
