package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.dto.SubmissionRequestDTO;

import java.util.List;

public interface SubmissionService {

    public List<SubmissionDTO> selectSubmissionByRecommendCount(int relay_id, int week);

    public List<SubmissionDTO> selectSubmissionByRegisterDate(int relay_id, int week);

    Integer registerSubmission(SubmissionRequestDTO requestDTO);

    Integer deleteSubmission(Integer submissionId);
}
