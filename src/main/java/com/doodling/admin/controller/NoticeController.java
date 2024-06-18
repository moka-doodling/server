package com.doodling.admin.controller;

import com.doodling.admin.dto.NoticeInsertRequest;
import com.doodling.admin.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/*")
@AllArgsConstructor
public class NoticeController {

    private NoticeService service;

    @PostMapping("/notice")
    public ResponseEntity<String> insert(@RequestBody NoticeInsertRequest request) throws Exception {
        service.insertNotice(request);
        return new ResponseEntity<>("success to insert notify", HttpStatus.OK);
    }

    @PatchMapping("/notice/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws Exception {
        Long notice_id = Long.parseLong(id);
        service.deleteNotice(notice_id);
        return new ResponseEntity<>("success to delete notify", HttpStatus.OK);
    }

}
