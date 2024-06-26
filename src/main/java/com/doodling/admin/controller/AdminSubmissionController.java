package com.doodling.admin.controller;

import com.doodling.admin.service.AdminSubmissionService;
import com.doodling.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Admin 페이지에서 당선작 선정 및 선정 취소
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
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminSubmissionController {

    private final AdminSubmissionService service;

    //당선작 선정
    @PatchMapping("/submission/{submissionId}")
    public ResponseEntity<String> selectSubmission(@PathVariable Integer submissionId) {
        boolean result = service.selectSubmission(submissionId);

        if (result) {
            return ResponseEntity.ok("success to select submission");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to select submission");
        }

    }

    //당선작 선정 취소
    @PatchMapping("/unsubmission/{submissionId}")
    public ResponseEntity<String> selectCancelSubmission(@PathVariable Integer submissionId) {
        boolean result = service.cancelSubmission(submissionId);

        if (result) {
            return ResponseEntity.ok("success to cancel submission");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to cancel submission");
        }

    }
}
