package com.doodling.member.dto;

import lombok.Getter;

/**
 * 토큰 발급 시 필요한 데이터 클래스
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
@Getter
public class ReissueTokenDTO {

  private String username;
  private String refreshToken;
}
