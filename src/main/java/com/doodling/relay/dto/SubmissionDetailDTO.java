package com.doodling.relay.dto;

import lombok.*;

/**
 * 공모전 상세 클래스
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
public class SubmissionDetailDTO {
    // 공모전 아이디
    private Integer submissionId;
    // 공모전 작성자
    private String username;
    // 글
    private String content;
    // 그림 url
    private String sketch;
}
