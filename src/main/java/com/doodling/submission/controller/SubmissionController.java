package com.doodling.submission.controller;


import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.dto.SubmissionRequestDTO;
import com.doodling.submission.dto.SubmissionResponseDTO;
import com.doodling.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
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

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<Integer> registerSubmission(@RequestBody SubmissionRequestDTO requestDTO) {
        Integer submissionId = service.registerSubmission(requestDTO);
        return ResponseEntity.ok(submissionId);
    }

    @DeleteMapping("/{submission_id}")
    public ResponseEntity<Integer> deleteSubmission(@PathVariable("submission_id") Integer submissionId) {
        Integer deletedSubmissionId = service.deleteSubmission(submissionId);
        return ResponseEntity.ok(deletedSubmissionId);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping
    public ResponseEntity<List<SubmissionResponseDTO>> getSelectedSubmissions(@RequestParam int relay_id, @RequestParam int is_selected) {
        List<SubmissionResponseDTO> response = service.selectSubmissionsByRelayIdAndIsSelected(relay_id, is_selected);
        return ResponseEntity.ok(response);
    }


}
