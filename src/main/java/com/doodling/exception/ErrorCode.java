package com.doodling.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@AllArgsConstructor
@Getter
public enum ErrorCode {

  /* code: 400 */
  INVALID_REFRESH_TOKEN(BAD_REQUEST, "유효하지 않은 리프레시 토큰입니다."),

  /* code: 401 */
  INVALID_AUTH_TOKEN(UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),
  INVALID_USERNAME(UNAUTHORIZED, "username이 올바르지 않습니다."),
  INVALID_MEMBER_ID(UNAUTHORIZED, "member Id가 올바르지 않습니다.");

  private final HttpStatus httpStatus;
  private final String detail;
}
