package com.doodling.recommend.service;

import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
import com.doodling.recommend.domain.Recommend;
import com.doodling.recommend.dto.RecommendRequestDTO;
import com.doodling.recommend.mapper.RecommendMapper;
import com.doodling.submission.mapper.SubmissionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final RecommendMapper recommendMapper;
    private final SubmissionMapper submissionMapper;

    @Override
    public Integer recommend(RecommendRequestDTO recommendRequestDTO) {
        Recommend recommend = Recommend.builder()
                .memberId(recommendRequestDTO.getMemberId())
                .submissionId(recommendRequestDTO.getSubmissionId())
                .build();

        recommendMapper.insertRecommend(recommend);
        submissionMapper.increaseRecommendCnt(recommendRequestDTO.getSubmissionId());

        return submissionMapper
                .selectSubmissionById(recommendRequestDTO.getSubmissionId())
                .getRecommendCnt();
    }

    @Override
    public Integer unrecommend(RecommendRequestDTO recommendRequestDTO) {
        Recommend recommend = Recommend.builder()
                .memberId(recommendRequestDTO.getMemberId())
                .submissionId(recommendRequestDTO.getSubmissionId())
                .build();

        recommendMapper.cancelRecommend(recommend);
        submissionMapper.decreaseRecommendCnt(recommendRequestDTO.getSubmissionId());

        return submissionMapper
                .selectSubmissionById(recommendRequestDTO.getSubmissionId())
                .getRecommendCnt();
    }

    @Override
    public boolean isRecommend(RecommendRequestDTO recommendRequestDTO) {
        Recommend recommend = Recommend.builder()
                .memberId(recommendRequestDTO.getMemberId())
                .submissionId(recommendRequestDTO.getSubmissionId())
                .build();

        int result = recommendMapper.countRecommendByMemberId(recommend);

        return result == 1;
    }
}
