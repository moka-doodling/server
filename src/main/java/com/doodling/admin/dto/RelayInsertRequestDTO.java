package com.doodling.admin.dto;

import lombok.*;

import java.util.Date;

/**
 * 공모전 등록 요청 클래스
 *
 * @author 김지현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.18    김지현       최초 생성
 * </pre>
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelayInsertRequestDTO {

    //공모전 제목
    private String title;
    //공모전 표지
    private String cover;
    //공모전 연령대
    private Integer age;
    //공모전 시작일
    private Date startdate;
    //공모전 종료일
    private Date enddate;

}
