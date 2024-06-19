package com.doodling.admin.controller;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.dto.NoticeListResponseDTO;
import com.doodling.admin.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminNoticeController {

    private final NoticeService service;

    @PostMapping("/notice")
    public ResponseEntity<String> insert(@RequestBody NoticeInsertRequestDTO request) throws Exception {
        service.insertNotice(request);
        return ResponseEntity.ok("success to insert notify");
    }

    @PatchMapping("/notice/{noticeId}")
    public ResponseEntity<String> delete(@PathVariable Integer noticeId) {
        boolean result = service.deleteNotice(noticeId);

        if (result) {
            return ResponseEntity.ok("success to delete notify");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete notice");
        }
    }

    @GetMapping("/notice/list")
    public ResponseEntity<List<NoticeListResponseDTO>> getNoticeList() {
        List<NoticeListResponseDTO> response = service.getNoticeList();
        return ResponseEntity.ok(response);
    }

}
