package com.doodling.submission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;
import java.util.Date;

/**
 * 제출물(submission) 상세 응답 클래스
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
public class SubmissionDetailResponseDTO {

    // 릴레이 아이디
    private Integer relayId;
    // 글
    private String content;
    // 그림 url
    private String sketch;
    // 등록 날짜
    private Date regdate;
    // 추천 수
    private Integer recommendCnt;

}
