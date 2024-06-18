package com.doodling.relay.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Book {
    private Integer relayId;
    private Integer submissionId;
    private Integer week;
    private String username;
    private String content;
    private String sketch;
}
