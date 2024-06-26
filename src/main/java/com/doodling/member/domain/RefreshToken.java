package com.doodling.member.domain;

import lombok.*;

import java.util.Date;

/**
 * refresh 토큰 클래스
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
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshToken {

  // 토큰 고유번호
  private Integer tokenId;
  // refresh 토큰
  private String refreshToken;
  // 토큰 소유자 고유번호
  private Integer memberId;
  // 토큰 저장일
  private Date regdate;
  // 토큰 만료일
  private Date expiredate;
}
