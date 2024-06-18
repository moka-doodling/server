package com.doodling.submission.mapper;

import com.doodling.submission.dto.SubmissionRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubmissionMapper {
    void insertSubmission(SubmissionRequestDto requestDto);
}
