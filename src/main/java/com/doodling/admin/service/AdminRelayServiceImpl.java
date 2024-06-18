package com.doodling.admin.service;

import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.mapper.AdminRelayMapper;
import com.doodling.relay.domain.Relay;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AdminRelayServiceImpl implements AdminRelayService {

    private final AdminRelayMapper mapper;

    @Override
    public void insertRelay(RelayInsertRequestDTO request) {
        Relay relay = Relay.builder()
                .title(request.getTitle())
                .cover(request.getCover())
                .age(request.getAge())
                .startdate(request.getStartdate())
                .enddate(request.getEnddate())
                .build();
        log.info("insert relay -> " + relay);
        mapper.insertRelay(relay);
    }
}
