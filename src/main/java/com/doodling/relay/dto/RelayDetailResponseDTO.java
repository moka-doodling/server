package com.doodling.relay.dto;

import lombok.*;

import java.util.Map;

/**
 * 릴레이 상세 응답 클래스
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
public class RelayDetailResponseDTO {
    // 릴레이 아이디
    private Integer relayId;
    // 공모전 상세
    private Map<Integer, SubmissionDetailDTO> submissions;
}
