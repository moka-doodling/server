package com.doodling.admin.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeInsertRequestDTO {

    private Integer noticeId;
    private String title;
    private String content;

}
