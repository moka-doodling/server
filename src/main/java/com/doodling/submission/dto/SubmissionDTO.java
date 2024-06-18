package com.doodling.submission.dto;

import lombok.*;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionDTO {

    private int submission_id;
    private int member_id;
    private int recommend_cnt;
    private Date regdate;
    private Date deletedate;
    private String content;
    private Blob sketch;
}
