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
    public ResponseEntity<Boolean> recommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Boolean>(service.recommend(recommendRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping ("")
    public ResponseEntity<Boolean> cancelRecommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        return new ResponseEntity<Boolean>(service.unrecommend(recommendRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkRecommend(@RequestBody RecommendRequestDTO recommendRequestDTO) {
        //true면 추천 O, false면 추천 X
        return new ResponseEntity<Boolean>(service.isRecommend(recommendRequestDTO), HttpStatus.OK);
    }

}
