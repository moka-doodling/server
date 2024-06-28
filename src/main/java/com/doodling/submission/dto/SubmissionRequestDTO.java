package com.doodling.submission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;

/**
 * 제출물(submission) 요청 클래스
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

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SubmissionRequestDTO {

    // 제출물 아이디
    private Integer submissionId;
    // 릴레이 아이디
    private Integer relayId;
    // 제출자 아이디
    private Integer memberId;
    // 제출 주차
    private Integer week;
    // 글
    private String content;
    // 그림 url
    private String sketch;
}
