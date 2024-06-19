package com.doodling.submission.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmissionOtherListResponseDTO {

    private Integer submissionId;
    private String username;
    private Integer recommendCnt;
    private Date regdate;
    private String content;
    private String sketch;

}
