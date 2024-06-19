package com.doodling.submission.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class OtherSubmission {

    private Integer submissionId;
    private String username;
    private Integer recommendCnt;
    private Date regdate;
    private String content;
    private String sketch;

}
