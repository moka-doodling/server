package com.doodling.relay.domain;

import lombok.*;

/**
 * 완료된 릴레이 (책) 클래스
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Book {
    // 릴레이 아이디
    private Integer relayId;
    // 공모전 아이디
    private Integer submissionId;
    // 릴레이 주차
    private Integer week;
    // 작성자
    private String username;
    // 글
    private String content;
    // 그림 url
    private String sketch;
}
