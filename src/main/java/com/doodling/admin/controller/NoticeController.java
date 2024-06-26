package com.doodling.admin.controller;

import com.doodling.admin.dto.NoticeInsertRequestDTO;

import com.doodling.admin.dto.NoticeResponseDTO;

import com.doodling.admin.dto.NoticeListResponseDTO;

import com.doodling.admin.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 페이지에서 공지사항 관리
 *
 * @author 김지현
 * @since 2024.06.20
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.20    김지현       최초 생성
 * </pre>
 */
@RestController
@AllArgsConstructor
public class NoticeController {

    private final NoticeService service;

    //공지사항 등록
    @PostMapping("/admin/notice")
    public ResponseEntity<String> insert(@RequestBody NoticeInsertRequestDTO request) throws Exception {
        service.insertNotice(request);
        return ResponseEntity.ok("success to insert notify");
    }

    //공지사항 삭제
    @PatchMapping("/admin/notice/{noticeId}")
    public ResponseEntity<String> delete(@PathVariable Integer noticeId) {
        boolean result = service.deleteNotice(noticeId);

        if (result) {
            return ResponseEntity.ok("success to delete notify");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete notice");
        }
    }

    //Admin 페이지에서 공지사항 리스트 조회
    @GetMapping("/admin/notice/list")
    public ResponseEntity<List<NoticeListResponseDTO>> getNoticeListForAdmin() {
        List<NoticeListResponseDTO> response = service.getNoticeList();
        return ResponseEntity.ok(response);
    }

    //Member(일반 사용자) 페이지에서 공지사항 리스트 조회
    @GetMapping("/notice/list")
    public ResponseEntity<List<NoticeListResponseDTO>> getNoticeListForMember() {
        List<NoticeListResponseDTO> response = service.getNoticeList();
        return ResponseEntity.ok(response);
    }

    //Admin 페이지에서 공지사항 상세 조회
    @GetMapping("/admin/notice/list/{noticeId}")
    public ResponseEntity<NoticeResponseDTO> getNoticeForAdmin(@PathVariable Integer noticeId) {
        return ResponseEntity.ok(service.getNotice(noticeId));
    }

    //Member(일반 사용자) 페이지에서 공지사항 상세 조회
    @GetMapping("/notice/list/{noticeId}")
    public ResponseEntity<NoticeResponseDTO> getNoticeForMember(@PathVariable Integer noticeId) {
        return ResponseEntity.ok(service.getNotice(noticeId));
    }
}
