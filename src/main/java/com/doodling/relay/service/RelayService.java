package com.doodling.relay.service;

import com.doodling.relay.dto.RelayResponseDTO;
import java.util.List;

public interface RelayService {

    List<RelayResponseDTO> getAllBookRelays();
}
