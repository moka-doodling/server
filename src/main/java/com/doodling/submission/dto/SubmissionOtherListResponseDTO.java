package com.doodling.submission.dto;

import lombok.*;

import java.util.Date;

/**
 * 다른 사람 제출물(submission) 클래스
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubmissionOtherListResponseDTO {

    // 제출물 아이디
    private Integer submissionId;
    // 제출자 이름
    private String username;
    // 추천 수
    private Integer recommendCnt;
    // 등록 날짜
    private Date regdate;
    // 글
    private String content;
    // 그림 url
    private String sketch;
    // 당선 여부
    private Boolean isSelected;

}
