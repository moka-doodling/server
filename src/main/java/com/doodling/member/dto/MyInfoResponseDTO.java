package com.doodling.member.dto;

import lombok.*;

/**
 * 내 정보 클래스
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
@RequiredArgsConstructor
@Getter
@Builder
public class MyInfoResponseDTO {

  // 멤버 고유 번호
  private Integer memberId;
  // 멤버 아이디
  private String username;
  // 당선 횟수
  private Integer selected_cnt;
}
