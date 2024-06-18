package com.doodling.submission.controller;

import com.doodling.submission.dto.SubmissionIsSelectedResponseDTO;
import com.doodling.submission.dto.SubmissionMySubmitResponseDTO;
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
    public ResponseEntity<List<SubmissionResponseDTO>> getRecommendList(@RequestParam Integer relayId, @RequestParam Integer week, @RequestParam String sort) {
        List<SubmissionResponseDTO> response;
        if (sort.equals("recommend")) {
            response = service.selectSubmissionByRecommendCount(relayId, week);
        } else {
            response = service.selectSubmissionByRegisterDate(relayId, week);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Integer> registerSubmission(@RequestBody SubmissionRequestDTO requestDTO) {
        Integer submissionId = service.registerSubmission(requestDTO);
        return ResponseEntity.ok(submissionId);
    }

    @DeleteMapping("/{submissionId}")
    public ResponseEntity<Integer> deleteSubmission(@PathVariable("submissionId") Integer submissionId) {
        Integer deletedSubmissionId = service.deleteSubmission(submissionId);
        return ResponseEntity.ok(deletedSubmissionId);
    }

    @GetMapping
    public ResponseEntity<List<SubmissionIsSelectedResponseDTO>> getSelectedSubmissions(@RequestParam Integer relayId, @RequestParam Boolean isSelected) {
        List<SubmissionIsSelectedResponseDTO> response = service.selectSubmissionsByRelayIdAndIsSelected(relayId, isSelected);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/my")
    public ResponseEntity<SubmissionMySubmitResponseDTO> getMySubmission(
            @RequestParam Integer relayId,
            @RequestParam Integer week,
            @RequestParam Integer memberId) {
        SubmissionMySubmitResponseDTO response = service.getMySubmission(relayId, week, memberId);
        return ResponseEntity.ok(response);
    }


}
