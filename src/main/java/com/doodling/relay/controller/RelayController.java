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

/**
 * 릴레이(공모전) 관련 컨트롤러
 *
 * @author 이주현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자    수정내용
 * ---------- -------- ---------------------
 * 2024.06.18 이주현    최초 생성
 * 2024.06.21 김지수    페이징 처리 추가
 * </pre>
 */

@RestController
@RequestMapping("/relay")
@RequiredArgsConstructor
@Slf4j
public class RelayController {

    private final RelayService relayService;

    /**
     * 완성된 책(종료된 릴레이) 목록 모두 조회
     * @return List<RelayResponseDTO>
     */
    @GetMapping("/book/all")
    public ResponseEntity<List<RelayResponseDTO>> getAllBookRelays() {
        List<RelayResponseDTO> relayResponseDTOs = relayService.getAllBookRelays();
        return ResponseEntity.ok(relayResponseDTOs);
    }

    /**
     * 릴레이 전체 목록 조회
     * @param filtering
     * @return List<RelayResponseDTO>
     */
    @GetMapping("/all")
    public ResponseEntity<List<RelayResponseDTO>> getAllRelays(@RequestParam("filtering") String filtering) {
        return ResponseEntity.ok(relayService.getAllRelays(filtering));
    }

    /**
     * 완성된 책(종료된 릴레이) 상세 조회
     * @param relayId
     * @return RelayDetailResponseDTO
     */
    @GetMapping("/book/{relayId}")
    public ResponseEntity<RelayDetailResponseDTO> getBookRelayDetail(@PathVariable("relayId") Integer relayId) {
        RelayDetailResponseDTO relayDetailResponseDTO = relayService.getBookRelayDetail(relayId);
        return ResponseEntity.ok(relayDetailResponseDTO);
    }

    /**
     * 완성된 책(종료된 릴레이) 연령대별 페이징
     * @param offset
     * @param age
     * @return BookPageDTO
     */
    @GetMapping("/book")
    public ResponseEntity<BookPageDTO> getAllBooksPaging(@RequestParam("offset") Integer offset, @RequestParam("age") Integer age) {
        BookPageDTO result = relayService.getBooksPaging(offset, age);
        return ResponseEntity.ok(result);
    }
}
