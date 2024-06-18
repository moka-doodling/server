package com.doodling.submission.controller;


import com.doodling.submission.dto.SubmissionResponse;
import com.doodling.submission.service.SubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/submission/*")
@AllArgsConstructor
public class SubmissionController {

    private SubmissionService service;

    @GetMapping("/list")
    public List<SubmissionResponse> getRecommendList(@RequestParam int relay_id, @RequestParam int week, @RequestParam String sort) {
        List<SubmissionResponse> response;
        if (sort.equals("recommend")) {
            response = service.selectSubmissionByRecommendCount(relay_id, week);
        } else {
            response = service.selectSubmissionByRegisterDate(relay_id, week);
        }

        return response;
    }
}
