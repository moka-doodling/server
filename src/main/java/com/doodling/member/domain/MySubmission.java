package com.doodling.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 내 제출물 클래스
 *
 * @author 김지수
 * @since 2024.6.20
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.20  김지수         최초 생성
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MySubmission {

  // 제출물 고유번호
  private Integer submissionId;
  // 공모전 고유번호
  private Integer relayId;
  // 멤버 고유번호
  private Integer memberId;
  // 추천받은 횟수
  private Integer recommendCnt;
  // 해당 공모전의 몇주차인지
  private Integer week;
  // 제출물 제출일
  private Date regdate;
  // 제출물 제목
  private String title;
  // 제출물 당선됐는지 유무
  private Boolean isSelected;
  // 제출물 이미지 BLOB 데이터
  private String sketch;
}
