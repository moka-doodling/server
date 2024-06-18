package com.doodling.submission.mapper;

import com.doodling.submission.dto.SubmissionResponse;

import java.util.List;

public interface SubmissionMapper {

    public List<SubmissionResponse> selectSubmissionByRecommendCount();

    public List<SubmissionResponse> selectSubmissionByRegisterDate();
}
