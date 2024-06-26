package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 비밀번호 변경 클래스
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChangePasswordDTO {

  // 이전 비밀번호
  private String oldPassword;
  // 새 비밀번호
  private String newPassword;
  // 비밀번호 확인
  private String passwordValidation;
}
