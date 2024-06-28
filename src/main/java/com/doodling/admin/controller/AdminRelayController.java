package com.doodling.admin.controller;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.service.AdminRelayService;
import com.doodling.admin.dto.RelayListResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin 페이지에서 공모전 관리
 *
 * @author 김지현
 * @since 2024.06.22
 * @version 1.0
 *
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.22    김지현       최초 생성
 * </pre>
 */
@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@Slf4j
public class AdminRelayController {

    private final AdminRelayService service;

    //공모전 등록
    @PostMapping("/relay")
    public ResponseEntity<Integer> insert(@RequestBody RelayInsertRequestDTO request) throws Exception {
        log.info("relay 등록: " + request.toString());
        Integer relayId = service.insertRelay(request);
        System.out.println(relayId);
        return ResponseEntity.ok(relayId);
    }

    //공모전 삭제
    @PatchMapping("/relay/{relayId}")
    public ResponseEntity<String> delete(@PathVariable("relayId") Integer relayId) throws Exception {
        log.info("relay 삭제 : " + relayId);
        service.deleteRelay(relayId);
        return ResponseEntity.ok("success to delete relay");
    }

    //공모전 리스트 조회
    @GetMapping("/relay/list")
    public ResponseEntity<List<RelayListResponseDTO>> getRelayList() {
        return ResponseEntity.ok(service.getRelayList());
    }
}
