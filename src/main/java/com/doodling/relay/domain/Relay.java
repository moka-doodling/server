package com.doodling.relay.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
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
