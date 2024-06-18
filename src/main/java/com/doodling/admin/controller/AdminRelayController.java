package com.doodling.admin.controller;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.service.AdminRelayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminRelayController {

    private AdminRelayService service;

    @PostMapping("/relay")
    public ResponseEntity<String> insert(@RequestBody RelayInsertRequestDTO request) throws Exception {
        service.insertRelay(request);
        return new ResponseEntity<>("success to insert relay", HttpStatus.OK);
    }
}
