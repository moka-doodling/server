package com.doodling.admin.mapper;

import com.doodling.admin.dto.NoticeInsertRequest;

public interface NoticeMapper {

    public void insertNotice(NoticeInsertRequest request);
    public void deleteNotice(Long notice_id);

}
