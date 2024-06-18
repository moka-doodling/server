package com.doodling.relay.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RelayDetailResponseDTO {
    private Integer relayId;
    private Map<Integer, SubmissionDetailDTO> submissions;
}
