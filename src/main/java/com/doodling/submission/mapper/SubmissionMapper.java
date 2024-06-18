package com.doodling.submission.mapper;

import com.doodling.submission.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.List;

public interface SubmissionMapper {

    List<Submission> selectSubmissionByRecommendCount(@Param("relay_id") int relay_id, @Param("week") int week);

    List<Submission> selectSubmissionByRegisterDate(@Param("relay_id") int relay_id, @Param("week") int week);

    Integer insertSubmission(Submission requestDTO);

    Integer deleteSubmission(Integer submissionId);

    List<Submission> selectSubmissionsByRelayIdAndIsSelected(@Param("relay_id") int relayId, @Param("is_selected") int isSelected);
}
