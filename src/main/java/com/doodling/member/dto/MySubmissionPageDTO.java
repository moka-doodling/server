package com.doodling.member.dto;

import com.doodling.global.dto.Criteria;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MySubmissionPageDTO {
  private boolean prev, next;

  private Integer total;
  private Criteria cri;
  private List<MySubmissionResponseDTO> mySubmissions;

  @Builder
  public MySubmissionPageDTO(Integer total, Criteria cri, List<MySubmissionResponseDTO> mySubmissions) {
    this.cri = cri;
    this.total = total;
    this.mySubmissions = mySubmissions;

    int pageSize = cri.getPageSize();
    int pageNum = cri.getPageNum();

    int realEnd = (int) (Math.ceil(total * 1.0 / pageSize));

    this.prev = pageNum > 1;
    this.next = pageNum < realEnd;
  }
}
