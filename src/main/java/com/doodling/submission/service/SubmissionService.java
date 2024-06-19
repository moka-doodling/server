package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDetailResponseDTO;

import com.doodling.submission.dto.SubmissionIsSelectedResponseDTO;
import com.doodling.submission.dto.SubmissionMySubmitResponseDTO;

import com.doodling.submission.dto.SubmissionRequestDTO;
import com.doodling.submission.dto.SubmissionResponseDTO;

import java.util.List;

public interface SubmissionService {

    List<SubmissionResponseDTO> selectSubmissionByRecommendCount(Integer relayId, Integer week);

    List<SubmissionResponseDTO> selectSubmissionByRegisterDate(Integer relayId, Integer week);

    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    Integer deleteSubmission(Integer submissionId);

    SubmissionDetailResponseDTO getSubmissionById(Integer submissionId);

    List<SubmissionIsSelectedResponseDTO> selectSubmissionsByRelayIdAndIsSelected(Integer relayId, Boolean isSelected);

    SubmissionMySubmitResponseDTO getMySubmission(Integer relayId, Integer week, Integer memberId);

}
