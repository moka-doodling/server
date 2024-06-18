package com.doodling.relay.service;

import com.doodling.relay.domain.Relay;
import com.doodling.relay.dto.RelayResponseDTO;
import com.doodling.relay.mapper.RelayMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RelayServiceImpl implements RelayService {

    private final RelayMapper relayMapper;

    @Override
    public List<RelayResponseDTO> getAllBookRelays() {
        List<Relay> result = relayMapper.selectAllBookRelays();
        log.info(result + "");
        return result.stream().map(relay -> RelayResponseDTO.builder().relayId(relay.getRelayId()).title(relay.getTitle()).cover(relay.getCover()).age(relay.getAge()).build()).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<RelayResponseDTO> getAllRelays(String filtering) {
        List<Relay> relays;

        final int IS_END_ONGOING = 0;
        final int IS_END_ENDED = 1;

        if ("ongoing".equals(filtering)) {
            relays = relayMapper.selectAllOngoingRelays(IS_END_ONGOING);
        } else {
            relays = relayMapper.selectAllOngoingRelays(IS_END_ENDED);
        }

        return relays.stream()
                .map(relay -> RelayResponseDTO.builder()
                        .relayId(relay.getRelayId())
                        .title(relay.getTitle())
                        .cover(relay.getCover())
                        .age(relay.getAge())
                        .build())
                .collect(Collectors.toList());
    }
}
