package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.dto.SubmissionRequestDTO;
import com.doodling.submission.dto.SubmissionResponseDTO;

import java.util.List;

public interface SubmissionService {

    List<SubmissionDTO> selectSubmissionByRecommendCount(int relay_id, int week);

    List<SubmissionDTO> selectSubmissionByRegisterDate(int relay_id, int week);

    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    Integer deleteSubmission(Integer submissionId);

    List<SubmissionResponseDTO> selectSubmissionsByRelayIdAndIsSelected(int relayId, int isSelected);
}
