package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionResponse;

import java.util.List;

public interface SubmissionService {

    public List<SubmissionResponse> selectSubmissionByRecommendCount(int relay_id, int week);

    public List<SubmissionResponse> selectSubmissionByRegisterDate(int relay_id, int week);

}
