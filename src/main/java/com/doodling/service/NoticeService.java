package com.doodling.service;

import com.doodling.dto.NoticeInsertRequest;

public interface NoticeService {

    public void insertNotice(NoticeInsertRequest request) throws Exception;

    public void deleteNotice(Long notice_id) throws Exception;
}
