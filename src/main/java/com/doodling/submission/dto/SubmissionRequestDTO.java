package com.doodling.submission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionRequestDTO {

    private Integer submissionId;
    private Integer relayId;
    private Integer memberId;
    private Integer week;
    private String content;
    private String sketch;
}
