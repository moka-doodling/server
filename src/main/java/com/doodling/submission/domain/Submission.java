package com.doodling.submission.domain;

import lombok.*;

import java.sql.Blob;
import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
public class Submission {

    private Integer submissionId;
    private Integer relayId;
    private Integer memberId;
    private Integer recommendCnt;
    private Date regdate;
    private Date deletedate;
    private Integer week;
    private String content;
    private Boolean isSelected;
    private String sketch;
}
