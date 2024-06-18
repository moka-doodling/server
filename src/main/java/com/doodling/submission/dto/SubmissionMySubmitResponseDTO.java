package com.doodling.submission.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionMySubmitResponseDTO {

    private Integer submissionId;
    private String content;
    private String sketch;
    private Integer recommendCnt;
    private Date regdate;

}
