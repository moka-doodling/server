package com.doodling.relay.dto;


import com.doodling.relay.domain.Criteria;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BookPageDTO {
  private boolean prev, next;

  private Integer total;
  private Criteria cri;
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
