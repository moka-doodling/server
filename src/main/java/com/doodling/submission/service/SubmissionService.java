package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.dto.SubmissionRequestDTO;
import com.doodling.submission.dto.SubmissionResponseDTO;

import java.util.List;

public interface SubmissionService {

    List<SubmissionResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week);

    List<SubmissionResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week);

    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    Integer deleteSubmission(Integer submissionId);

    List<SubmissionResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected);

}
