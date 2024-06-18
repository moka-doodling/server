package com.doodling.admin.service;

public interface AdminSubmissionService {

    boolean updateSelectedCnt(Integer memberId);
    Integer selectMember(Integer submissionId);
    boolean selectSubmission(Integer submissionId);

}
