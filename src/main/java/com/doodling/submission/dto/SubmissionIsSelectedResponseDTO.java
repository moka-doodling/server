package com.doodling.submission.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionIsSelectedResponseDTO {

    private Integer submissionId;
    private Integer memberId;
    private Integer week;
    private String content;
    private String sketch;

}
