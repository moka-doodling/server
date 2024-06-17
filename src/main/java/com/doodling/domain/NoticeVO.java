package com.doodling.domain;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeVO {

    private Long notice_id;
    private String title;
    private String content;
    private Date regdate;
    private Date deletedate;

}
