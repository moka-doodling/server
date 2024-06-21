package com.doodling.relay.service;

import com.doodling.relay.dto.BookPageDTO;
import com.doodling.relay.dto.RelayDetailResponseDTO;
import com.doodling.relay.dto.RelayResponseDTO;
import java.util.List;

public interface RelayService {

    List<RelayResponseDTO> getAllBookRelays();
    List<RelayResponseDTO> getAllRelays(String filtering);
    RelayDetailResponseDTO getBookRelayDetail(Integer relayId);
    BookPageDTO getBooksPaging(Integer offset, Integer age);
}
