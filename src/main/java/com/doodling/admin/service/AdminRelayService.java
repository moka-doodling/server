package com.doodling.admin.service;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.dto.RelayListResponseDTO;

import java.util.List;

public interface AdminRelayService {

    //공모전 등록
    Integer insertRelay(RelayInsertRequestDTO request);
    //공모전 삭제
    boolean deleteRelay(Integer relayId);
    //공모전 전체 리스트 불러오기
    List<RelayListResponseDTO> getRelayList();
}
