package com.doodling.admin.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private Long notice_id;
    private String title;
    private String content;
    private Date regdate;
    private Date deletedate;

}
