package com.doodling.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RelayInsertRequestDTO {

    private String title;
    private String cover;
    private Integer age;
    private Date startdate;
    private Date enddate;

}
