package com.doodling.member.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class MyInfoResponseDTO {

  private Integer memberId;
  private String username;
  private Integer selected_cnt;
}
