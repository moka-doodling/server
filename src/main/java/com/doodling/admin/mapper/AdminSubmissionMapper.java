package com.doodling.admin.mapper;

import com.doodling.member.domain.Member;

public interface AdminSubmissionMapper {

    //submissionId로 유저 조회
    Integer selectMember(Integer submissionId);
    //submissionId로 제출물 당선작 선정
    int selectSubmission(Integer submissionId);
    //submissionId로 제출물 당선작 선정 취소
    int cancelSubmission(Integer submissionId);

}
