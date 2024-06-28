package com.doodling.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 추천 요청 클래스
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RecommendRequestDTO {

    //추천한 유저 id
    private Integer memberId;
    //추천한 게시물 id
    private Integer submissionId;

}
