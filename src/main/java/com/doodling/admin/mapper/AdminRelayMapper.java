package com.doodling.admin.mapper;

import com.doodling.relay.domain.Relay;

import java.util.List;

public interface AdminRelayMapper {

    void insertRelay(Relay relay);
    int deleteRelay(Integer relayId);
    List<Relay> selectAllRelays();
}
