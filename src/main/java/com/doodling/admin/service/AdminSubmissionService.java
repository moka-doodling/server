package com.doodling.admin.service;

public interface AdminSubmissionService {

    boolean selectSubmission(Integer submissionId);
    boolean cancelSubmission(Integer submissionId);

}
