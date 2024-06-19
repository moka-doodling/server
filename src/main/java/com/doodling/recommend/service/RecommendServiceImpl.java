package com.doodling.recommend.service;

import com.doodling.recommend.domain.Recommend;
import com.doodling.recommend.dto.RecommendRequestDTO;
import com.doodling.recommend.mapper.RecommendMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final RecommendMapper recommendMapper;

    @Override
    public boolean recommend(RecommendRequestDTO recommendRequestDTO) {
        Recommend recommend = Recommend.builder()
                .memberId(recommendRequestDTO.getMemberId())
                .submissionId(recommendRequestDTO.getSubmissionId())
                .build();

        log.info(recommend.toString());
        int result = recommendMapper.countRecommendByMemberId(recommend);
        if (result == 0) {
            recommendMapper.insertRecommend(recommend);
            return true;
        }
        return false;
    }

    @Override
    public boolean unrecommend(RecommendRequestDTO recommendRequestDTO) {
        Recommend recommend = Recommend.builder()
                .memberId(recommendRequestDTO.getMemberId())
                .submissionId(recommendRequestDTO.getSubmissionId())
                .build();
        int result = recommendMapper.cancelRecommend(recommend);

        return result == 1;
    }
}
