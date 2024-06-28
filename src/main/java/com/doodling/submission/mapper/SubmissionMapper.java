package com.doodling.submission.mapper;

import com.doodling.submission.domain.OtherSubmission;
import com.doodling.submission.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.List;

public interface SubmissionMapper {

    // 추천순으로 다른 사람 제출물 조회
    List<OtherSubmission> selectSubmissionByRecommendCount(@Param("relayId") Integer relayId, @Param("week") Integer week);

    // 등록순으로 다른 사람 제출물 조회
    List<OtherSubmission> selectSubmissionByRegisterDate(@Param("relayId") Integer relayId, @Param("week") Integer week);

    // 릴레이 동화 제출하기
    Integer insertSubmission(Submission submission);

    // 제출한 릴레이 동화 삭제하기
    Integer deleteSubmission(Integer submissionId);

    // 해당 릴레이의 주차별 당선작 목록 상세 조회
    List<Submission> selectSubmissionsByRelayIdAndIsSelected(@Param("relayId") Integer relayId, @Param("isSelected") Boolean isSelected);

    // 종료된 릴레이 중 미당선된 submission 상세 조회
    Submission selectSubmissionById(Integer submissionId);

    // 제출한 submission 상세 조회
    Submission selectMySubmission(@Param("relayId") Integer relayId, @Param("week") Integer week, @Param("memberId") Integer memberId);

    // 추천수 증가
    int increaseRecommendCnt(Integer submissionId);

    // 추천수 감소
    int decreaseRecommendCnt(Integer submissionId);
}
