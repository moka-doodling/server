package com.doodling.relay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

/**
 * 릴레이 응답 클래스
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
public class RelayResponseDTO {
    // 릴레이 아이디
    private Integer relayId;
    // 릴레이 제목
    private String title;
    // 릴레이 표지 그림 url
    private String cover;
    // 릴레이 연령대 (0이면 유치부 1이면 초등부)
    private Integer age;
}
