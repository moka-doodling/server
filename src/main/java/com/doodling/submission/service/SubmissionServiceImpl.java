package com.doodling.submission.service;

import com.doodling.submission.domain.Submission;
import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.dto.SubmissionRequestDTO;
import com.doodling.submission.dto.SubmissionResponseDTO;
import com.doodling.submission.mapper.SubmissionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionMapper mapper;

    @Override
    public List<SubmissionResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week) {
        return mapper.selectSubmissionByRecommendCount(relayId, week).stream()
                .map(submission -> SubmissionResponseDTO.builder()
                        .submissionId(submission.getSubmissionId())
                        .memberId(submission.getMemberId())
                        .recommendCnt(submission.getRecommendCnt())
                        .regdate(submission.getRegdate())
                        .content(submission.getContent())
                        .sketch(submission.getSketch())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<SubmissionResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week) {
        return mapper.selectSubmissionByRegisterDate(relayId, week).stream()
                .map(submission -> SubmissionResponseDTO.builder()
                        .submissionId(submission.getSubmissionId())
                        .memberId(submission.getMemberId())
                        .recommendCnt(submission.getRecommendCnt())
                        .regdate(submission.getRegdate())
                        .content(submission.getContent())
                        .sketch(submission.getSketch())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Integer registerSubmission(SubmissionRequestDTO requestDTO) {
        Submission submission = Submission.builder()
                .relayId(requestDTO.getRelayId())
                .memberId(requestDTO.getMemberId())
                .week(requestDTO.getWeek())
                .content(requestDTO.getContent())
                .sketch(requestDTO.getSketch())
                .build();

        mapper.insertSubmission(submission);

        return submission.getSubmissionId();
    }

    @Transactional
    @Override
    public Integer deleteSubmission(Integer submissionId) {
        return mapper.deleteSubmission(submissionId);
    }

    @Transactional
    @Override
    public List<SubmissionResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected) {
        return mapper.selectSubmissionsByRelayIdAndIsSelected(relayId, isSelected).stream()
                .map(submission -> {
                    return SubmissionResponseDTO.builder()
                            .submissionId(submission.getSubmissionId())
                            .relayId(submission.getRelayId())
                            .memberId(submission.getMemberId())
                            .week(submission.getWeek())
                            .content(submission.getContent())
                            .sketch(submission.getSketch())
                            .regdate(submission.getRegdate())
                            .recommendCnt(submission.getRecommendCnt())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
