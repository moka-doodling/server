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

/**
 * 추천 도메인
 *
 * @author 김지현
 * @since 2024.06.19
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.19    김지현       최초 생성
 * </pre>
 */
@Slf4j
@Service
@AllArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final RecommendMapper recommendMapper;
    private final SubmissionMapper submissionMapper;

    /**
     * 추천 등록
     * @param recommendRequestDTO
     * @return 해당 제출물의 총 추천수
     */
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

    /**
     * 추천 취소
     * @param recommendRequestDTO
     * @return 해당 제출물의 총 추천수
     */
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

    /**
     * 추천 여부 확인
     * @param recommendRequestDTO
     * @return 추천 여부
     */
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
