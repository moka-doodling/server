package com.doodling.relay.controller;

import com.doodling.relay.dto.BookPageDTO;
import com.doodling.relay.dto.RelayDetailResponseDTO;
import com.doodling.relay.service.RelayService;
import com.doodling.relay.dto.RelayResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relay")
@RequiredArgsConstructor
@Slf4j
public class RelayController {

    private final RelayService relayService;

    @GetMapping("/book/all") // 완성된 책(종료된 릴레이) 모두 조회
    public ResponseEntity<List<RelayResponseDTO>> getAllBookRelays() {
        List<RelayResponseDTO> relayResponseDTOs = relayService.getAllBookRelays();
        return ResponseEntity.ok(relayResponseDTOs);
    }

    @GetMapping("/all") // 공모전
    public ResponseEntity<List<RelayResponseDTO>> getAllRelays(@RequestParam("filtering") String filtering) {
        return ResponseEntity.ok(relayService.getAllRelays(filtering));
    }
  
    @GetMapping("/book/{relayId}")
    public ResponseEntity<RelayDetailResponseDTO> getBookRelayDetail(@PathVariable("relayId") Integer relayId) {
        RelayDetailResponseDTO relayDetailResponseDTO = relayService.getBookRelayDetail(relayId);
        return ResponseEntity.ok(relayDetailResponseDTO);
    }

    @GetMapping("/book")
    public ResponseEntity<BookPageDTO> getAllBooksPaging(@RequestParam("offset") Integer offset) {
        BookPageDTO result = relayService.getBooksPaging(offset);
        log.info(result + "");
        return ResponseEntity.ok(result);
    }
}
