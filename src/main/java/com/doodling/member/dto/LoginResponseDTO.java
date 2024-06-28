package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 로그인 성공 시 전달되는 응답에 담을 데이터 클래스
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
public class LoginResponseDTO {

  // access token
  private String accessToken;
  // refresh token
  private String refreshToken;
  // 멤버 고유 번호
  private Integer memberId;
}
