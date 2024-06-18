package com.doodling.admin.service;

import com.doodling.admin.mapper.AdminSubmissionMapper;
import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
import com.doodling.member.domain.Member;
import com.doodling.member.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AdminSubmissionServiceImpl implements AdminSubmissionService {

    private final AdminSubmissionMapper adminSubmissionMapper;
    private final MemberMapper memberMapper;

    @Override
    public boolean updateSelectedCnt(Integer memberId) {
        int result = memberMapper.updateSelectedCnt(memberId);

        if (result == 0) throw new CustomException(ErrorCode.FAIL_TO_UPDATE);

        return result == 1;
    }

    @Override
    public Integer selectMember(Integer submissionId) {
         return adminSubmissionMapper.selectMember(submissionId);
    }

    @Override
    public boolean selectSubmission(Integer submissionId) {
        log.info("selected submission -> " + submissionId);
        int result = adminSubmissionMapper.selectSubmission(submissionId);

        if (result == 0) throw new CustomException(ErrorCode.FAIL_TO_UPDATE);

        return result == 1;
    }
}
