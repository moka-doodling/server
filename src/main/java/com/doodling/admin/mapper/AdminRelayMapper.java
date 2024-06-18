package com.doodling.admin.mapper;

import com.doodling.relay.domain.Relay;

public interface AdminRelayMapper {

    void insertRelay(Relay relay);
    int deleteRelay(Integer relayId);
}
