package com.doodling.mapper;

import com.doodling.dto.NoticeInsertRequest;

public interface NoticeMapper {

    public void insertNotice(NoticeInsertRequest request);
    public void deleteNotice(Long notice_id);

}
