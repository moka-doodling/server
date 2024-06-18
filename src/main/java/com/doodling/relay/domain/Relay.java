package com.doodling.relay.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Relay {

    private Integer relayId;
    private Date startdate;
    private Date enddate;
    private String title;
    private Integer age;
    private String cover;
    private Boolean isEnd;

}