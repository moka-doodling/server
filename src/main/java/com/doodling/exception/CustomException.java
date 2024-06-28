package com.doodling.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 커스텀 예외 클래스
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
@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {

  // 전달할 에러 코드
  private final ErrorCode errorCode;
}
