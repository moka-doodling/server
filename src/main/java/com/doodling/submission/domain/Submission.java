package com.doodling.submission.domain;

import lombok.*;

import java.sql.Blob;
import java.util.Date;

/**
 * 제출물(submission) 클래스
 *
 * @author 이주현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자    수정내용
 * ---------- -------- ---------------------
 * 2024.06.18 이주현    최초 생성
 * </pre>
 */

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
