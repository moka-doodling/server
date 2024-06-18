package com.doodling.submission.mapper;

import com.doodling.submission.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.List;

public interface SubmissionMapper {

    List<Submission> selectSubmissionByRecommendCount(@Param("relayId") Integer relayId, @Param("week") Integer week);

    List<Submission> selectSubmissionByRegisterDate(@Param("relayId") Integer relayId, @Param("week") Integer week);

    Integer insertSubmission(Submission submission);

    Integer deleteSubmission(Integer submissionId);

    List<Submission> selectSubmissionsByRelayIdAndIsSelected(@Param("relayId") Integer relayId, @Param("isSelected") Boolean isSelected);
}
