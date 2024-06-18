package com.doodling.recommend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RecommendRequestDTO {

    private Integer recommendId;
    private Integer memberId;
    private Integer submissionId;

}
