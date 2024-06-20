package com.doodling.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RelayListResponseDTO {

    private Integer relayId;
    private Date startdate;
    private Date enddate;
    private String title;
    private Integer age;
    private String cover;
    private Boolean isEnd;

}
