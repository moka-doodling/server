package com.doodling.admin.controller;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.service.AdminRelayService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminRelayController {

    private final AdminRelayService service;

    @PostMapping("/relay")
    public ResponseEntity<String> insert(@RequestBody RelayInsertRequestDTO request) throws Exception {
        log.info("relay 등록: " + request.toString());
        service.insertRelay(request);
        return ResponseEntity.ok("success to insert relay");
    }

    @PatchMapping("/relay/{relayId}")
    public ResponseEntity<String> delete(@PathVariable("relayId") Integer relayId) throws Exception {
        log.info("relay 삭제 : " + relayId);
        service.deleteRelay(relayId);
        return ResponseEntity.ok("success to delete relay");
    }
}
