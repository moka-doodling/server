package com.doodling.admin.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
public class Notice {

    private Integer noticeId;
    private String title;
    private String content;
    private Date regdate;
    private Date deletedate;

}
