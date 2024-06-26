package com.doodling.member.dto;

import lombok.*;

import java.util.Date;

/**
 * 내 제출물 조회 시 넘길 데이터 클래스
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
@Builder
@Getter
public class MySubmissionResponseDTO {

  private Integer relayId;
  private Integer submissionId;
  private Boolean isSelected;
  private Integer recommendCnt;
  private String title;
  private String sketch;
  private Date regdate;
}
