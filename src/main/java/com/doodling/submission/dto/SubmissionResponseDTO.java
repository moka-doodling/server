package com.doodling.submission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionResponseDTO {

    private Integer submissionId;
    private Integer relayId;
    private Integer memberId;
    private Integer week;
    private String content;
    private String sketch;
    private Date regdate;
    private Integer recommendCnt;

}
