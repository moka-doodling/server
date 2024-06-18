package com.doodling.submission.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

    private Integer submissionId;
    private Integer relayId;
    private Integer memberId;
    private Integer recommendCount;
    private java.sql.Date regDate;
    private java.sql.Date deleteDate;
    private Integer week;
    private String content;
    private Integer isSelected;
    private String sketch;

}
