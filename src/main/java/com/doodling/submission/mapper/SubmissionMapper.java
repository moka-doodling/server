package com.doodling.submission.mapper;

import com.doodling.submission.domain.OtherSubmission;
import com.doodling.submission.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.List;

public interface SubmissionMapper {

    List<OtherSubmission> selectSubmissionByRecommendCount(@Param("relayId") Integer relayId, @Param("week") Integer week);

    List<OtherSubmission> selectSubmissionByRegisterDate(@Param("relayId") Integer relayId, @Param("week") Integer week);

    Integer insertSubmission(Submission submission);

    Integer deleteSubmission(Integer submissionId);

    List<Submission> selectSubmissionsByRelayIdAndIsSelected(@Param("relayId") Integer relayId, @Param("isSelected") Boolean isSelected);

    Submission selectSubmissionById(Integer submissionId);

    Submission selectMySubmission(@Param("relayId") Integer relayId, @Param("week") Integer week, @Param("memberId") Integer memberId);
}
