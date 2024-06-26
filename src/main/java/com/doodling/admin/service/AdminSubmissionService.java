package com.doodling.admin.service;

public interface AdminSubmissionService {

    //제출물 당선작 선정
    boolean selectSubmission(Integer submissionId);
    //제출물 당선작 선정 취소
    boolean cancelSubmission(Integer submissionId);

}
