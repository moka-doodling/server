package com.doodling.recommend.controller;

import com.doodling.member.domain.Member;
import com.doodling.recommend.domain.Recommend;
import com.doodling.recommend.dto.RecommendRequestDTO;
import com.doodling.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * 다른 사람의 게시물 추천 관리
 *
 * @author 김지현
 * @since 2024.06.19
 * @version 1.0
 *
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.19    김지현       최초 생성
 * </pre>
 */
@RestController
@RequestMapping("/submission/recommend")
@RequiredArgsConstructor
@Slf4j
public class RecommendController {

    private final RecommendService service;

    //추천
    @PostMapping("")
    public ResponseEntity<Integer> recommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Integer>(service.recommend(recommendRequestDTO), HttpStatus.OK);
    }

    //추천 취소
    @DeleteMapping ("")
    public ResponseEntity<Integer> cancelRecommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Integer>(service.unrecommend(recommendRequestDTO), HttpStatus.OK);
    }

    //추천 여부 조회
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkRecommend(
            @RequestParam("memberId") Integer memberId,
            @RequestParam("submissionId") Integer submissionId) {
        RecommendRequestDTO recommendRequestDTO = RecommendRequestDTO.builder()
                .memberId(memberId)
                .submissionId(submissionId)
                .build();
        return new ResponseEntity<Boolean>(service.isRecommend(recommendRequestDTO), HttpStatus.OK);
    }

}
