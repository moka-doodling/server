package com.doodling.member.dto;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
public class MySubmissionResponseDTO {

  private Integer relayId;
  private Integer submissionId;
  private Boolean isSelected;
  private Integer recommendCnt;
}
