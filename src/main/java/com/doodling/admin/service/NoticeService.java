package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;

public interface NoticeService {

    public void insertNotice(NoticeInsertRequestDTO request);

    public boolean deleteNotice(Integer noticeId);
}
