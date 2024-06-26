package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 로그인이 성공적으로 되었다면, 넘길 토큰 클래스
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
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@ToString
public class TokenDTO {

  private String accessToken;
  private String refreshToken;
}
