package com.doodling.member.dto;

import lombok.*;

import java.util.Date;

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
