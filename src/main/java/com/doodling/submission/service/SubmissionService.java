package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionRequestDto;
import com.doodling.submission.dto.SubmissionResponseDto;

public interface SubmissionService {
    SubmissionResponseDto registerSubmission(SubmissionRequestDto request);
}
