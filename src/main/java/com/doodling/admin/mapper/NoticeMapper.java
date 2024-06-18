package com.doodling.admin.mapper;

import com.doodling.admin.dto.NoticeInsertRequestDTO;

public interface NoticeMapper {

    void insertNotice(NoticeInsertRequestDTO request);
    int deleteNotice(Integer noticeId);

}
