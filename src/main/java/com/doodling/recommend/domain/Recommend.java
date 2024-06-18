package com.doodling.recommend.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Recommend {

    private Integer recommendId;
    private Integer memberId;
    private Integer submissionId;

}
