package com.doodling.admin.service;

import com.doodling.admin.mapper.AdminSubmissionMapper;
import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
import com.doodling.member.domain.Member;
import com.doodling.member.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AdminSubmissionServiceImpl implements AdminSubmissionService {

    private final AdminSubmissionMapper adminSubmissionMapper;
    private final MemberMapper memberMapper;

    @Override
    public boolean selectSubmission(Integer submissionId) {
        log.info("selected submission -> " + submissionId);
        int result1 = adminSubmissionMapper.selectSubmission(submissionId); //0이면 fail, 1이면 success
        int result2 = memberMapper.updateSelectedCnt(adminSubmissionMapper.selectMember(submissionId));

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        if (result1 == 0 || result2 == 0) throw new CustomException(ErrorCode.FAIL_TO_UPDATE);

        return true;
    }
}
