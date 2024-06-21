package com.doodling.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Criteria {

  private Integer pageSize;
  private Integer pageNum;

  private String type;
  private String keyword;
}
