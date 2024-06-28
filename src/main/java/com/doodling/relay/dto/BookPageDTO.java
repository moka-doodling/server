package com.doodling.relay.dto;

import com.doodling.global.dto.Criteria;
import lombok.*;

import java.util.List;

/**
 * 완성된 책 목록 리스트 페이징
 *
 * @author 김지수
 * @since 2024.06.21
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자    수정내용
 * ---------- -------- ---------------------
 * 2024.06.21 김지수    최초 생성
 * </pre>
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BookPageDTO {
  // 이전, 이후 값이 있는 지 없는 지
  private boolean prev, next;

  // 데이터 총 개수
  private Integer total;
  // 페이지 정보
  private Criteria cri;
  // 릴레이 응답 리스트
  private List<RelayResponseDTO> books;

  @Builder
  public BookPageDTO(Integer total, Criteria cri, List<RelayResponseDTO> books) {
    this.cri = cri;
    this.total = total;
    this.books = books;

    int pageSize = cri.getPageSize();
    int pageNum = cri.getPageNum();

    int realEnd = (int) (Math.ceil(total * 1.0 / pageSize));

    this.prev = pageNum > 1;
    this.next = pageNum < realEnd;
  }
}
