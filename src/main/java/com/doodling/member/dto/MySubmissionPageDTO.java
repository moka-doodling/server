package com.doodling.member.dto;

import com.doodling.global.dto.Criteria;
import lombok.*;

import java.util.List;

/**
 * 내 제출물 페이징 조회 시 넘길 데이터 클래스
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
@Getter
@ToString
public class MySubmissionPageDTO {
  private boolean prev, next;

  // 내가 제출한 페이지 데이터 총 갯수
  private Integer total;
  // 데이터 페이징 기준
  private Criteria cri;
  // 페이징 조회한 제출물 데이터
  private List<MySubmissionResponseDTO> mySubmissions;

  @Builder
  public MySubmissionPageDTO(Integer total, Criteria cri, List<MySubmissionResponseDTO> mySubmissions) {
    this.cri = cri;
    this.total = total;
    this.mySubmissions = mySubmissions;

    int pageSize = cri.getPageSize();
    int pageNum = cri.getPageNum();

    // 마지막 페이지 번호
    int realEnd = (int) (Math.ceil(total * 1.0 / pageSize));

    this.prev = pageNum > 1;
    this.next = pageNum < realEnd;
  }
}
