package com.doodling.relay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class RelayResponseDTO {
    private Integer relayId;
    private String title;
    private String cover;
    private Integer age;
}
