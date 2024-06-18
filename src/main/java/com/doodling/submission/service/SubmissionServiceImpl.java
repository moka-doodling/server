package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionRequestDto;
import com.doodling.submission.dto.SubmissionResponseDto;
import com.doodling.submission.mapper.SubmissionMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionMapper submissionMapper;

    @Transactional
    @Override
    public SubmissionResponseDto registerSubmission(SubmissionRequestDto request) {
        submissionMapper.insertSubmission(request);

        return SubmissionResponseDto.builder()
                .submissionId(request.getSubmissionId())
                .build();;
    }
}
