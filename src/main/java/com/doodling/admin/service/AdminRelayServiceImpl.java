package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeListResponseDTO;
import com.doodling.admin.dto.RelayInsertRequestDTO;
import com.doodling.admin.dto.RelayListResponseDTO;
import com.doodling.admin.mapper.AdminRelayMapper;
import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
import com.doodling.relay.domain.Relay;
import com.doodling.relay.dto.RelayResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class AdminRelayServiceImpl implements AdminRelayService {

    private final AdminRelayMapper mapper;

    @Override
    public Integer insertRelay(RelayInsertRequestDTO request) {
        Relay relay = Relay.builder()
                .title(request.getTitle())
                .cover(request.getCover())
                .age(request.getAge())
                .startdate(request.getStartdate())
                .enddate(request.getEnddate())
                .build();
        mapper.insertRelay(relay);
        log.info("insert relay -> " + relay);
        return relay.getRelayId();
    }

    @Override
    public boolean deleteRelay(Integer relayId) {
        log.info("delete relay -> " + relayId);
        int result = mapper.deleteRelay(relayId);

        if (result == 0) throw new CustomException(ErrorCode.FAIL_TO_DELETE);

        return result == 1;
    }

    @Override
    public List<RelayListResponseDTO> getRelayList() {
        List<Relay> result = mapper.selectAllRelays();
        log.info("result -> " + result);

        return result.stream()
                .map(relay -> RelayListResponseDTO.builder()
                        .relayId(relay.getRelayId())
                        .title(relay.getTitle())
                        .cover(relay.getCover())
                        .age(relay.getAge())
                        .startdate(relay.getStartdate())
                        .enddate(relay.getEnddate())
                        .isEnd(relay.getIsEnd())
                        .build())
                .collect(Collectors.toList());
    }
}
