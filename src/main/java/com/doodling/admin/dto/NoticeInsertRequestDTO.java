package com.doodling.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeInsertRequestDTO {

    private Integer noticeId;
    private String title;
    private String content;

}
