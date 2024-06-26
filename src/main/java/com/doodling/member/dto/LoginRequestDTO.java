package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 요청 클래스
 *
 * @author 김지수
 * @since 2024.6.17
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.17  김지수         최초 생성
 * </pre>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class LoginRequestDTO {

  // 사용자 아이디
  private String username;
  // 사용자 비밀번호
  private String password;
}