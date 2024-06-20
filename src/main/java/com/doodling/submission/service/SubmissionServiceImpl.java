package com.doodling.submission.service;

import com.doodling.submission.domain.Submission;

import com.doodling.submission.dto.*;

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

    @Transactional
    @Override
    public List<SubmissionOtherListResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week) {
        return mapper.selectSubmissionByRecommendCount(relayId, week).stream()
                .map(submission -> SubmissionOtherListResponseDTO.builder()
                        .submissionId(submission.getSubmissionId())
                        .username(submission.getUsername())
                        .recommendCnt(submission.getRecommendCnt())
                        .regdate(submission.getRegdate())
                        .content(submission.getContent())
                        .sketch(submission.getSketch())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<SubmissionOtherListResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week) {
        return mapper.selectSubmissionByRegisterDate(relayId, week).stream()
                .map(submission -> SubmissionOtherListResponseDTO.builder()
                        .submissionId(submission.getSubmissionId())
                        .username(submission.getUsername())
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
    public List<SubmissionIsSelectedResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected) {
        return mapper.selectSubmissionsByRelayIdAndIsSelected(relayId, isSelected).stream()
                .map(submission -> {
                    return SubmissionIsSelectedResponseDTO.builder()
                            .submissionId(submission.getSubmissionId())
                            .memberId(submission.getMemberId())
                            .week(submission.getWeek())
                            .content(submission.getContent())
                            .sketch(submission.getSketch())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SubmissionDetailResponseDTO getSubmissionById(Integer submissionId) {
        Submission submission = mapper.selectSubmissionById(submissionId);
            return SubmissionDetailResponseDTO.builder()
                    .relayId(submission.getRelayId())
                    .content(submission.getContent())
                    .sketch(submission.getSketch())
                    .recommendCnt(submission.getRecommendCnt())
                    .regdate(submission.getRegdate())
                    .build();
    }

    @Override
    @Transactional
    public SubmissionMySubmitResponseDTO getMySubmission(Integer relayId, Integer week, Integer memberId) {
        Submission submission = mapper.selectMySubmission(relayId, week, memberId);
        if (submission == null) {
            return null;
        }
        return SubmissionMySubmitResponseDTO.builder()
                .submissionId(submission.getSubmissionId())
                .content(submission.getContent())
                .sketch(submission.getSketch())
                .recommendCnt(submission.getRecommendCnt())
                .regdate(submission.getRegdate())
                .build();
    }
}
