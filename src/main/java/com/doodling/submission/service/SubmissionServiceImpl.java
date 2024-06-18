package com.doodling.submission.service;

import com.doodling.submission.dto.SubmissionDTO;
import com.doodling.submission.mapper.SubmissionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionMapper mapper;

    @Override
    public List<SubmissionDTO> selectSubmissionByRecommendCount(int relay_id, int week) {
        return mapper.selectSubmissionByRecommendCount(relay_id, week).stream()
                .map(submission -> SubmissionDTO.builder()
                        .submission_id(submission.getSubmission_id())
                        .member_id(submission.getMember_id())
                        .recommend_cnt(submission.getRecommend_cnt())
                        .regdate(submission.getRegdate())
                        .deletedate(submission.getDeletedate())
                        .content(submission.getContent())
                        .sketch(submission.getSketch())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<SubmissionDTO> selectSubmissionByRegisterDate(int relay_id, int week) {
        return mapper.selectSubmissionByRegisterDate(relay_id, week).stream()
                .map(submission -> SubmissionDTO.builder()
                        .submission_id(submission.getSubmission_id())
                        .member_id(submission.getMember_id())
                        .recommend_cnt(submission.getRecommend_cnt())
                        .regdate(submission.getRegdate())
                        .deletedate(submission.getDeletedate())
                        .content(submission.getContent())
                        .sketch(submission.getSketch())
                        .build())
                .collect(Collectors.toList());
    }
}
