package com.doodling.admin.domain;

import lombok.*;

import java.util.Date;

/**
 * 공지사항 클래스
 *
 * @author 김지현
 * @since 2024.06.19
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.19    김지현       최초 생성
 * </pre>
 */
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
@Getter
public class Notice {

    //고유번호
    private Integer noticeId;
    //공지사항 제목
    private String title;
    //공지사항 내용
    private String content;
    //공지사항 등록일
    private Date regdate;
    //공지사항 삭제일
    private Date deletedate;

}
