package com.doodling.recommend.controller;

import com.doodling.recommend.domain.Recommend;
import com.doodling.recommend.dto.RecommendRequestDTO;
import com.doodling.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submission/recommend/*")
@RequiredArgsConstructor
@Slf4j
public class RecommendController {

    private final RecommendService service;

    @PostMapping("/{submissionId}")
    public ResponseEntity<Boolean> recommend(@PathVariable Integer submissionId) {
        //여기에서 memberId를 가져와서 넣어야 함
        Integer memberId = 1;

        RecommendRequestDTO recommendRequestDTO = RecommendRequestDTO.builder()
                .submissionId(submissionId)
                .memberId(memberId)
                .build();
        System.out.println("memberId" + memberId);
        System.out.println("submissionId" + submissionId);

        //이미 한번 했으면 등록 못하도록 해야 함 -> 여기서 처리?

        return new ResponseEntity<Boolean>(service.recommend(recommendRequestDTO), HttpStatus.OK);
    }

}
