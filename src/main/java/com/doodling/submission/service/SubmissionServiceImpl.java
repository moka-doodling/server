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

/**
 * 제출물(submission) 서비스 구현
 *
 * @author 김지현, 이주현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자         수정내용
 * ---------- ------------- ---------------------
 * 2024.06.18 김지현, 이주현   최초 생성
 * </pre>
 */

@Slf4j
@Service
@AllArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionMapper mapper;

    /**
     * 해당 공모전의 다른 사용자 제출물 추천순으로 조회
     * @param relayId
     * @param week
     * @return List<SubmissionOtherListResponseDTO>
     */
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
                        .isSelected(submission.getIsSelected())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 해당 공모전의 다른 사용자 제출물 최신순으로 조회
     * @param relayId
     * @param week
     * @return List<SubmissionOtherListResponseDTO>
     */
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
                        .isSelected(submission.getIsSelected())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * 릴레이 동화 제출하기
     * @param requestDTO
     * @return 등록된  submissionId
     */
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

    /**
     * 제출한 릴레이 동화 삭제하기
     * @param submissionId
     * @return 삭제된 submissionId
     */
    @Transactional
    @Override
    public Integer deleteSubmission(Integer submissionId) {
        return mapper.deleteSubmission(submissionId);
    }

    /**
     * 해당 릴레이의 주차별 당선작 목록 상세 조회
     * @param relayId
     * @param isSelected
     * @return List<SubmissionIsSelectedResponseDTO>
     */
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

    /**
     * 종료된 릴레이 중 미당선된 submission 상세 조회
     * @param submissionId
     * @return SubmissionDetailResponseDTO
     */
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

    /**
     * 제출한 submission 상세 조회
     * @param relayId
     * @param week
     * @param memberId
     * @return
     */
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
