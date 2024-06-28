package com.doodling.admin.mapper;

import com.doodling.relay.domain.Relay;

import java.util.List;

public interface AdminRelayMapper {

    //공모전 삽입
    void insertRelay(Relay relay);
    //relayId로 공모전 삭제
    int deleteRelay(Integer relayId);
    //공모전 전체 목록 조회
    List<Relay> selectAllRelays();
}
