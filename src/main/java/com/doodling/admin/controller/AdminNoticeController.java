package com.doodling.admin.controller;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminNoticeController {

    private NoticeService service;

    @PostMapping("/notice")
    public ResponseEntity<String> insert(@RequestBody NoticeInsertRequestDTO request) throws Exception {
        service.insertNotice(request);
        return new ResponseEntity<>("success to insert notify", HttpStatus.OK);
    }

    @PatchMapping("/notice/{noticeId}")
    public ResponseEntity<String> delete(@PathVariable Integer noticeId) throws Exception {
        service.deleteNotice(noticeId);
        return new ResponseEntity<>("success to delete notify", HttpStatus.OK);
    }

}
