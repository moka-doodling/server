package com.doodling.submission.dto;

import lombok.*;
import java.util.Date;

/**
 * 나의 제출물(submission) 응답 클래스
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
public class SubmissionMySubmitResponseDTO {

    // 제출물 아이디
    private Integer submissionId;
    // 글
    private String content;
    // 그림 url
    private String sketch;
    // 추천 수
    private Integer recommendCnt;
    // 등록 날짜
    private Date regdate;

}
