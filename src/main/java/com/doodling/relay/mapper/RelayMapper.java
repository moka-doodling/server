package com.doodling.relay.mapper;

import com.doodling.relay.domain.Relay;
import java.util.List;

public interface RelayMapper {

    List<Relay> selectAllBookRelays();
}
