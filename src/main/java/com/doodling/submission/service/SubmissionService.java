package com.doodling.submission.service;

import com.doodling.submission.dto.*;

import java.util.List;

public interface SubmissionService {

    List<SubmissionOtherListResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week);

    List<SubmissionOtherListResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week);

    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    Integer deleteSubmission(Integer submissionId);

    SubmissionDetailResponseDTO getSubmissionById(Integer submissionId);

    List<SubmissionIsSelectedResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected);

    SubmissionMySubmitResponseDTO getMySubmission(Integer relayId, Integer week, Integer memberId);

}
