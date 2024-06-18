package com.doodling.controller;

import com.doodling.domain.Notice;
import com.doodling.dto.NoticeInsertRequest;
import com.doodling.service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
