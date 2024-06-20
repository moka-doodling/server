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

@RestController
@AllArgsConstructor
public class NoticeController {

    private final NoticeService service;

    @PostMapping("/admin/notice")
    public ResponseEntity<String> insert(@RequestBody NoticeInsertRequestDTO request) throws Exception {
        service.insertNotice(request);
        return ResponseEntity.ok("success to insert notify");
    }

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

    @GetMapping("/admin/notice/list")
    public ResponseEntity<List<NoticeListResponseDTO>> getNoticeListForAdmin() {
        List<NoticeListResponseDTO> response = service.getNoticeList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/notice/list")
    public ResponseEntity<List<NoticeListResponseDTO>> getNoticeListForMember() {
        List<NoticeListResponseDTO> response = service.getNoticeList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin/notice/list/{noticeId}")
    public ResponseEntity<NoticeResponseDTO> getNoticeForAdmin(@PathVariable Integer noticeId) {
        return ResponseEntity.ok(service.getNotice(noticeId));
    }

    @GetMapping("/notice/list/{noticeId}")
    public ResponseEntity<NoticeResponseDTO> getNoticeForMember(@PathVariable Integer noticeId) {
        return ResponseEntity.ok(service.getNotice(noticeId));
    }
}
