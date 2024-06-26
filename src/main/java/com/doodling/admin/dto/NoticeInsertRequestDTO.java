package com.doodling.admin.dto;

import lombok.*;

/**
 * 공지사항 등록 요청 클래스
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
public class NoticeInsertRequestDTO {

    //고유번호
    private Integer noticeId;
    //공지사항 제목
    private String title;
    //공지사항 내용
    private String content;

}
