package com.doodling.recommend.service;

import com.doodling.recommend.domain.Recommend;
import com.doodling.recommend.mapper.RecommendMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final RecommendMapper mapper;

    @Override
    public boolean recommend(Recommend recommend) {
        log.info(recommend.toString());
        int result = mapper.countRecommendByMemberId(recommend);
        if (result == 0) {
            mapper.insertRecommend(recommend);
            return true;
        }
        return false;
    }
}
