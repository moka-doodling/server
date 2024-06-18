package com.doodling.submission.controller;


import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/submission/*")
@RequiredArgsConstructor
@Slf4j
public class SubmissionController {

    private final SubmissionService service;

    @GetMapping("/list")
    public ResponseEntity<List<SubmissionDTO>> getRecommendList(@RequestParam int relay_id, @RequestParam int week, @RequestParam String sort) {
        List<SubmissionDTO> response;
        if (sort.equals("recommend")) {
            response = service.selectSubmissionByRecommendCount(relay_id, week);
        } else {
            response = service.selectSubmissionByRegisterDate(relay_id, week);
        }

        return ResponseEntity.ok(response);
    }
}
