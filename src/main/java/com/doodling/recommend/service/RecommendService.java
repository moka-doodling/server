package com.doodling.recommend.service;

import com.doodling.recommend.dto.RecommendRequestDTO;

public interface RecommendService {

    Integer recommend(RecommendRequestDTO recommendRequestDTO);

    Integer unrecommend(RecommendRequestDTO recommendRequestDTO);

    boolean isRecommend(RecommendRequestDTO recommendRequestDTO);

}
