package com.doodling.recommend.mapper;

import com.doodling.recommend.domain.Recommend;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper {

    //추천 등록
    void insertRecommend(Recommend recommend);
    //해당 member가 해당 submission에 추천했는지 확인
    int countRecommendByMemberId(Recommend recommend);
    //추천 취소
    int cancelRecommend(Recommend recommend);
}
