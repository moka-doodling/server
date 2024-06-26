package com.doodling.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/**
 * 에러 클래스
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
public enum ErrorCode {

  /* code: 400*/
  DUPLICATE_REFRESH_TOKEN(BAD_REQUEST, "이미 만료된 리프레시 토큰입니다."),
  FAIL_TO_DELETE(UNAUTHORIZED, "삭제에 실패했습니다."),

  /* code: 401 */
  INVALID_USERNAME(UNAUTHORIZED, "username이 올바르지 않습니다."),
  MEMBER_NOT_FOUND(UNAUTHORIZED, "회원 정보를 찾을 수 없습니다."),
  PASSWORD_NOT_MATCH(UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
  PASSWORD_VALIDATION_FAILED(UNAUTHORIZED, "비밀번호 확인에 실패했습니다."),
  INVALID_MEMBER_ID(UNAUTHORIZED, "member Id가 올바르지 않습니다."),

  /* code: 409 */
  USERNAME_ALREADY_EXISTS(CONFLICT, "이미 존재하는 유저 아이디입니다."),

  /* code: 500 */
  DATABASE_ERROR(INTERNAL_SERVER_ERROR, "데이터베이스 오류가 발생했습니다."),
  FAIL_TO_UPDATE(UNAUTHORIZED, "수정에 실패했습니다."),
  ;

  private final HttpStatus httpStatus;
  private final String detail;
}
