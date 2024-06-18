package com.doodling.relay.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SubmissionDetailDTO {
    private Integer submissionId;
    private String username;
    private String content;
    private String sketch;
}
