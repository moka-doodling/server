package com.doodling.admin.controller;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.service.AdminRelayService;
import com.doodling.admin.dto.RelayListResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminRelayController {

    private final AdminRelayService service;

    @PostMapping("/relay")
    public ResponseEntity<Integer> insert(@RequestBody RelayInsertRequestDTO request) throws Exception {
        log.info("relay 등록: " + request.toString());
        Integer relayId = service.insertRelay(request);
        return ResponseEntity.ok(relayId);
    }

    @PatchMapping("/relay/{relayId}")
    public ResponseEntity<String> delete(@PathVariable("relayId") Integer relayId) throws Exception {
        log.info("relay 삭제 : " + relayId);
        service.deleteRelay(relayId);
        return ResponseEntity.ok("success to delete relay");
    }

    @GetMapping("/relay/list")
    public ResponseEntity<List<RelayListResponseDTO>> getRelayList() {
        return ResponseEntity.ok(service.getRelayList());
    }
}
