package com.doodling.admin.mapper;

import com.doodling.member.domain.Member;

public interface AdminSubmissionMapper {

    Integer selectMember(Integer submissionId);
    int selectSubmission(Integer submissionId);

}
