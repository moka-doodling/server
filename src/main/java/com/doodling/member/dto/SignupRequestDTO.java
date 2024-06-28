package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 시 필요한 클래스
 *
 * @author 김지수
 * @since 2024.6.19
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.19  김지수         최초 생성
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SignupRequestDTO {

  private String username;
  private String password;
  private String passwordValidation;
}
