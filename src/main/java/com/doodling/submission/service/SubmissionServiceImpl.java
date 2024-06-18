package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionResponse;
import com.doodling.submission.mapper.SubmissionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private SubmissionMapper mapper;

    @Override
    public List<SubmissionResponse> selectSubmissionByRecommendCount(int relay_id, int week) {
        return mapper.selectSubmissionByRecommendCount();
    }

    @Override
    public List<SubmissionResponse> selectSubmissionByRegisterDate(int relay_id, int week) {
        return mapper.selectSubmissionByRegisterDate();
    }
}
