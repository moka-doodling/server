package com.doodling.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 조회된 공모전 목록 응답 클래스
 *
 * @author 김지현
 * @since 2024.06.20
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.20    김지현       최초 생성
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class RelayListResponseDTO {

    //고유번호
    private Integer relayId;
    //공모전 시작일
    private Date startdate;
    //공모전 종료일
    private Date enddate;
    //공모전 제목
    private String title;
    //공모전 연령대
    private Integer age;
    //공모전 표지
    private String cover;
    //공모전 종료여부
    private Boolean isEnd;

}
