package com.doodling.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 페이징 조회하기 위한 클래스
 *
 * @author 김지수
 * @since 2024.6.21
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.21  김지수         최초 생성
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Criteria {

  // 한 페이지에 들어갈 데이터 크기
  private Integer pageSize;
  // 몇번째 페이지인지
  private Integer pageNum;

  // filtering 관련
  private String type;
  // 검색 시 사용되는 키워드
  private String keyword;
}
