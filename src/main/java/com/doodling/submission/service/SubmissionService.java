package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDTO;

import java.util.List;

public interface SubmissionService {

    public List<SubmissionDTO> selectSubmissionByRecommendCount(int relay_id, int week);

    public List<SubmissionDTO> selectSubmissionByRegisterDate(int relay_id, int week);
}
