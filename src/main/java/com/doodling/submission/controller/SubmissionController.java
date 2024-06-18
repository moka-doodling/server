package com.doodling.submission.controller;

import com.doodling.submission.dto.SubmissionRequestDto;
import com.doodling.submission.dto.SubmissionResponseDto;
import com.doodling.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<SubmissionResponseDto> registerSubmission(@RequestBody SubmissionRequestDto requestDto) {
        SubmissionResponseDto responseDto = submissionService.registerSubmission(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
