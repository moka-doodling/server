package com.doodling.recommend.service;

import com.doodling.recommend.dto.RecommendRequestDTO;

public interface RecommendService {

    boolean recommend(RecommendRequestDTO recommendRequestDTO);

    boolean unrecommend(RecommendRequestDTO recommendRequestDTO);

}
