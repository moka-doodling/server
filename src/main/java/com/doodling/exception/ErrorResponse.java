package com.doodling.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

  private final String error;
  private final Integer status;
  private final String msg;

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity
            .status(errorCode.getHttpStatus())
            .body(ErrorResponse.builder()
                    .status(errorCode.getHttpStatus().value())
                    .error(errorCode.getHttpStatus().name())
                    .msg(errorCode.getDetail())
                    .build()
            );
  }
}
