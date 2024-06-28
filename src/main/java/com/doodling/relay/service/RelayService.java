package com.doodling.relay.service;

import com.doodling.relay.dto.BookPageDTO;
import com.doodling.relay.dto.RelayDetailResponseDTO;
import com.doodling.relay.dto.RelayResponseDTO;
import java.util.List;

public interface RelayService {

    // 완성된 책(종료된 공모전) 리스트 조회
    List<RelayResponseDTO> getAllBookRelays();
    // 릴레이 전체 목록 조회
    List<RelayResponseDTO> getAllRelays(String filtering);
    // 완성된 책(종료된 공모전) 상세 조회
    RelayDetailResponseDTO getBookRelayDetail(Integer relayId);
    // 완성된 책(종료된 공모전) 페이징
    BookPageDTO getBooksPaging(Integer offset, Integer age);
}
