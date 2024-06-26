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

/**
 * Admin 당선작 선정 도메인
 *
 * @author 김지현
 * @since 2024.06.21
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.21    김지현       최초 생성
 * </pre>
 */
@Slf4j
@Service
@AllArgsConstructor
public class AdminSubmissionServiceImpl implements AdminSubmissionService {

    private final AdminSubmissionMapper adminSubmissionMapper;
    private final MemberMapper memberMapper;

    /**
     * 당선작 선정
     * @param submissionId
     * @return 선정 성공 여부
     */
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

    /**
     * 당선작 선정 취소
     * @param submissionId
     * @return 선정 취소 성공 여부
     */
    @Override
    public boolean cancelSubmission(Integer submissionId) {
        int result1 = adminSubmissionMapper.cancelSubmission(submissionId); //0이면 fail, 1이면 success
        int result2 = memberMapper.cancelSelectedCnt(adminSubmissionMapper.selectMember(submissionId));

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        if (result1 == 0 || result2 == 0) throw new CustomException(ErrorCode.FAIL_TO_UPDATE);

        return true;
    }
}
