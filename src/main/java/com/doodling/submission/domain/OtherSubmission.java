package com.doodling.submission.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * 다른 사람 제출물 클래스
 *
 * @author 김지현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자    수정내용
 * ---------- -------- ---------------------
 * 2024.06.18 김지현    최초 생성
 * </pre>
 */

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
    private Boolean isSelected;

}
