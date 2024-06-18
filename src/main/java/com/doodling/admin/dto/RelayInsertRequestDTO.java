package com.doodling.admin.dto;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelayInsertRequestDTO {

    private String title;
    private String cover;
    private Integer age;
    private Date startdate;
    private Date enddate;

}
