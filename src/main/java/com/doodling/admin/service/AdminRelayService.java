package com.doodling.admin.service;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.dto.RelayListResponseDTO;

import java.util.List;

public interface AdminRelayService {

    Integer insertRelay(RelayInsertRequestDTO request);
    boolean deleteRelay(Integer relayId);

    List<RelayListResponseDTO> getRelayList();
}
