package com.doodling.submission.domain;

import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
public class Submission {

    private int submission_id;
    private int relay_id;
    private int member_id;
    private int recommend_cnt;
    private Date regdate;
    private Date deletedate;
    private int week;
    private String content;
    private boolean is_selected;
    private Blob sketch;

}
