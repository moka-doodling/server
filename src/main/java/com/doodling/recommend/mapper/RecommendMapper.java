package com.doodling.recommend.mapper;

import com.doodling.recommend.domain.Recommend;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {

    void insertRecommend(Recommend recommend);
    int countRecommendByMemberId(Recommend recommend);
}
