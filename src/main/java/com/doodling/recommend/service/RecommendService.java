package com.doodling.recommend.service;

import com.doodling.recommend.dto.RecommendRequestDTO;

public interface RecommendService {

    //추천 등록
    Integer recommend(RecommendRequestDTO recommendRequestDTO);
    //추천 취소
    Integer unrecommend(RecommendRequestDTO recommendRequestDTO);
    //추천 여부 조회
    boolean isRecommend(RecommendRequestDTO recommendRequestDTO);

}
