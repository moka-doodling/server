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

@RestController
@RequestMapping("/submission/recommend")
@RequiredArgsConstructor
@Slf4j
public class RecommendController {

    private final RecommendService service;

    @PostMapping("")
    public ResponseEntity<Integer> recommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Integer>(service.recommend(recommendRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping ("")
    public ResponseEntity<Integer> cancelRecommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Integer>(service.unrecommend(recommendRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkRecommend(
            @RequestParam("memberId") Integer memberId,
            @RequestParam("submissionId") Integer submissionId) {
        RecommendRequestDTO recommendRequestDTO = RecommendRequestDTO.builder()
                .memberId(memberId)
                .submissionId(submissionId)
                .build();
        //true면 추천 O, false면 추천 X
        return new ResponseEntity<Boolean>(service.isRecommend(recommendRequestDTO), HttpStatus.OK);
    }

}
