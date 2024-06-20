package com.doodling.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MySubmission {

  private Integer submissionId;
  private Integer relayId;
  private Integer memberId;
  private Integer recommendCnt;
  private Integer week;
  private Date regdate;
  private String title;
  private Boolean isSelected;
  private String sketch;
}
