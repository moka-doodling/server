package com.doodling.submission.service;

import com.doodling.submission.dto.*;

import java.util.List;

public interface SubmissionService {

    // 추천순으로 다른 사람 제출물 조회
    List<SubmissionOtherListResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week);

    // 등록순으로 다른 사람 제출물 조회
    List<SubmissionOtherListResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week);

    // 릴레이 동화 제출하기
    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    // 제출한 릴레이 동화 삭제하기
    Integer deleteSubmission(Integer submissionId);

    // 종료된 릴레이 중 미당선된 submission 상세 조회
    SubmissionDetailResponseDTO getSubmissionById(Integer submissionId);

    // 해당 릴레이의 주차별 당선작 목록 상세 조회
    List<SubmissionIsSelectedResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected);

    // 제출한 submission 상세 조회
    SubmissionMySubmitResponseDTO getMySubmission(Integer relayId, Integer week, Integer memberId);

}
