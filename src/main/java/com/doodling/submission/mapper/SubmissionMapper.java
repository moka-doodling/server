package com.doodling.submission.mapper;

import com.doodling.submission.domain.Submission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubmissionMapper {

    List<Submission> selectSubmissionByRecommendCount(@Param("relay_id") int relay_id, @Param("week") int week);

    List<Submission> selectSubmissionByRegisterDate(@Param("relay_id") int relay_id, @Param("week") int week);
}
