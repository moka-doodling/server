package com.doodling.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

/**
 * 에러 발생 시 전달할 응답 클래스
 *
 * @author 김지수
 * @since 2024.6.18
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.18  김지수         최초 생성
 * </pre>
 */
@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {

  private final String error;
  private final Integer status;
  private final String msg;

  // 에러 응답 데이터 생성자
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
