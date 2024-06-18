package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequest;

public interface NoticeService {

    public void insertNotice(NoticeInsertRequest request) throws Exception;

    public void deleteNotice(Long notice_id) throws Exception;
}
