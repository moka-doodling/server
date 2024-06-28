package com.doodling.submission.controller;

import com.doodling.submission.dto.*;

import com.doodling.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 제출물(submission) 관련 컨트롤러
 *
 * @author 김지현, 이주현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자         수정내용
 * ---------- ------------- ---------------------
 * 2024.06.18 김지현, 이주현   최초 생성
 * </pre>
 */

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
@Slf4j
public class SubmissionController {

    private final SubmissionService service;

    /**
     * 해당 공모전의 다른 사용자 제출물 조회 (추천순/최신순)
     * @param relayId
     * @param week
     * @param sort
     * @return <List<SubmissionOtherListResponseDTO>>
     */
    @GetMapping("/list")
    public ResponseEntity<List<SubmissionOtherListResponseDTO>> getSubmissionList(@RequestParam Integer relayId, @RequestParam Integer week, @RequestParam String sort) {
        List<SubmissionOtherListResponseDTO> response;
        if (sort.equals("recommend")) {
            response = service.selectSubmissionByRecommendCount(relayId, week);
        } else {
            response = service.selectSubmissionByRegisterDate(relayId, week);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 릴레이 동화 제출하기
     * @param requestDTO
     * @return 등록된 submissionId
     */
    @PostMapping
    public ResponseEntity<Integer> registerSubmission(@RequestBody SubmissionRequestDTO requestDTO) {
        Integer submissionId = service.registerSubmission(requestDTO);
        return ResponseEntity.ok(submissionId);
    }

    /**
     * 제출한 submission 삭제
     * @param submissionId
     * @return 삭제된 deletedSubmissionId
     */
    @DeleteMapping("/{submissionId}")
    public ResponseEntity<Integer> deleteSubmission(@PathVariable("submissionId") Integer submissionId) {
        Integer deletedSubmissionId = service.deleteSubmission(submissionId);
        return ResponseEntity.ok(deletedSubmissionId);
    }

    /**
     * 해당 릴레이의 주차별 당선작 목록 상세 조회
     * @param relayId
     * @param isSelected
     * @return <List<SubmissionIsSelectedResponseDTO>>
     */
    @GetMapping
    public ResponseEntity<List<SubmissionIsSelectedResponseDTO>> getSelectedSubmissions(@RequestParam Integer relayId, @RequestParam Boolean isSelected) {
        List<SubmissionIsSelectedResponseDTO> response = service.selectSubmissionsByRelayIdAndIsSelected(relayId, isSelected);
        return ResponseEntity.ok(response);
    }

    /**
     * 제출한 submission 상세 조회
     * @param relayId
     * @param week
     * @param memberId
     * @return <SubmissionMySubmitResponseDTO>
     */
    @GetMapping("/my")
    public ResponseEntity<SubmissionMySubmitResponseDTO> getMySubmission(
            @RequestParam Integer relayId,
            @RequestParam Integer week,
            @RequestParam Integer memberId) {
        SubmissionMySubmitResponseDTO response = service.getMySubmission(relayId, week, memberId);
        return ResponseEntity.ok(response);
    }

    /**
     * 종료된 릴레이 중 미당선된 submission 상세 조회
     * @param submissionId
     * @return <SubmissionDetailResponseDTO>
     */
    @GetMapping("/{submissionId}")
    public ResponseEntity<SubmissionDetailResponseDTO> getSubmissionById(@PathVariable("submissionId") Integer submissionId) {
        SubmissionDetailResponseDTO response = service.getSubmissionById(submissionId);
            return ResponseEntity.ok(response);
    }
}
