package com.doodling.admin.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Notice {

    private Integer noticeId;
    private String title;
    private String content;
    private Date regdate;
    private Date deletedate;

}
