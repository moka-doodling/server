package com.doodling.relay.domain;

import lombok.*;

import java.util.Date;

/**
 * 릴레이(공모전) 클래스
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
@ToString
public class Relay {

    // 릴레이 아이디
    private Integer relayId;
    // 릴레이 시작 날짜
    private Date startdate;
    // 릴레이 종료 날짜
    private Date enddate;
    // 릴레이 제목
    private String title;
    // 릴레이 연령대 (0이면 유치부 1이면 초등부)
    private Integer age;
    // 릴레이 표지 그림 url
    private String cover;
    // 릴레이 종료 유무 (0이면 진행중 1이면 종료)
    private Boolean isEnd;
}
