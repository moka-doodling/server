package com.doodling.recommend.domain;

import lombok.*;

/**
 * 추천 클래스
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
@RequiredArgsConstructor
@Builder
@ToString
public class Recommend {

    //고유번호
    private Integer recommendId;
    //추천한 유저 id
    private Integer memberId;
    //추천한 게시물 id
    private Integer submissionId;

}
